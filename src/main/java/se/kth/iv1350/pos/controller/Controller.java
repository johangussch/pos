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
    private ItemDTO itemDTO = new ItemDTO(null, 0, 0);
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
    * @param itemID,itemQuantity The scanned item's ID and its quantity to be bought.
    * @return The sale information of the newly scanned item.
    */
    public SaleDTO enterItem(int itemID, int itemQuantity){
        item = inventorySystem.fetchItem(itemID);

        if (item == null) return null;

        this.sale.listSoldItem(item, itemQuantity);
        this.sale.runningTotal += itemDTO.itemPrice * itemQuantity;
        this.sale.totalVAT += itemDTO.itemVAT * itemQuantity;
        
        return this.sale.fetchSalelnfo();
    }
    
    /**
    * Handles the customer's payment of the sale.
    *
    * @param paidAmount The customer's payment amount for the sale.
    * @return The change to be returned to the customer.
    */
    public double enterPayment(double paidAmount){
        double change = paidAmount - this.sale.totalPrice;

        if (change > 0) { 
            register.increaseAmount(paidAmount - change);
        } else {
            register.increaseAmount(paidAmount);
        }
        
        return change;
    }
    
    /**
    * Ends the sale instance, saving the total price and paid amount of the sale to  and updating
    *
    * @param paidAmount The customer's payment amount for the sale.
    * @return The sale's total price (to be presented on screen, not implemented).
    */
    public double endSale(double paidAmount){
        this.sale.totalPrice = this.sale.runningTotal + this.sale.totalVAT;
        this.sale.paidAmount = paidAmount;

        if (sale.scannedItems != null) {
            accountingSystem.recordSoldItem(sale.scannedItems);
            inventorySystem.updateInventory(sale.scannedItems);
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
