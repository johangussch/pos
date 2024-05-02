/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;

/**
* The system the cashier interacts with in the pos scenario.
*/
public class Controller {
    private InventorySystem inventorySystem = new InventorySystem();
    private AccountingSystem accountingSystem = new AccountingSystem();
    private Register register = new Register();
    public Sale sale;
    private Item item = new Item(0, null, 0);
    private ItemDTO itemDTO = new ItemDTO(null, null, 0, 0);
    private Receipt receipt = new Receipt();

    /**
    * Creates a new sale instance.
    */
    public void createNewSale(){
        this.sale = new Sale();
    }

    /**
    * Lists the item(s) being sold by updating the inventory and sale information.
    *
    * @param itemID The scanned item's ID.
    * @param itemQuantity  The scanned item's quantity.
    * @return The sale information of the newly scanned item.
    */
    public SaleDTO enterItem(int itemID, int itemQuantity){
        item = inventorySystem.fetchItem(itemID);

        if (item == null) return null;

        this.sale.listSoldItem(item, itemQuantity);
        this.sale.runningTotal += itemDTO.itemPrice * itemQuantity;
        this.sale.totalVAT += itemDTO.itemVAT * itemQuantity;

        System.out.println("Add " + itemQuantity + " item with item id " + itemID + " :");
        System.out.println("Item ID : " + itemID);
        System.out.println("Item Name : " + itemDTO.fetchItemName());
        System.out.println("Item cost : " + itemDTO.fetchItemPrice() + " SEK");
        System.out.println("Item VAT : " + itemDTO.fetchItemVAT() + " %");
        System.out.println("Item Description : " + itemDTO.fetchItemDescription());

        System.out.println("\nTotal cost ( incl VAT ): " + sale.fetchTotalPrice() + " SEK");
        System.out.println("Total VAT : " + sale.fetchTotalVAT() + " SEK");

        return this.sale.fetchSalelnfo();
    }
    
    /**
    * Handles the customer's payment of the sale.
    *
    * @param paidAmount The customer's payment amount for the sale.
    */
    public void enterPayment(double paidAmount){
        double change = paidAmount - this.sale.totalPrice;

        if (change > 0) { 
            register.increaseAmount(paidAmount - change);
        } else {
            register.increaseAmount(paidAmount);
        }

        System.out.println("Change to give the customer : " + change + " SEK");
        
    }
    
    /**
    * Ends the sale instance, saving the total price and paid amount of the sale to  and updating
    *
    * @param paidAmount The customer's payment amount for the sale.
    * @return The sale's total price (to be presented on screen, not implemented).
    */
    public double endSale(double paidAmount){
        this.sale.totalPrice = sale.fetchRunningTotal() + sale.fetchTotalVAT();
        this.sale.paidAmount = paidAmount;
        
        System.out.println("\nEnd sale :");
        System.out.println("Total cost ( incl VAT ) : " + sale.fetchTotalPrice() + " SEK");
        System.out.println("\nCustomer pays : " + paidAmount + " SEK :");
        
        if (sale.soldItems != null) {
            accountingSystem.recordSoldItem(sale.soldItems);
            System.out.println("Sent sale info to external accounting system.");
            
            inventorySystem.updateInventory(sale.soldItems);
            if (sale.soldItems.size() == 0) {
                System.out.println("No items were scanned. No info sent to external inventory system.");
            }
            for (int i = 0; i < sale.soldItems.size(); i++) {
                System.out.println("Told external inventory system to decrease inventory quantity of item " + sale.soldItems.get(i) + ".");
            }
        }

        return this.sale.totalPrice;
    } 
    
    /**
    * Prints the receipt of the sale.
    */
    public void print() {
        receipt.printReceipt(this.sale);
    }
}
