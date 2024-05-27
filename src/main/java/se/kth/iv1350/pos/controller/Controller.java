/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.util.*;
import se.kth.iv1350.pos.view.ConsoleTotalRevenueDisplay;

import java.util.List;
import java.util.ArrayList;

/**
* The system the cashier interacts with in the pos scenario.
*/
public class Controller {
    private InventorySystem inventorySystem = new InventorySystem();
    private AccountingSystem accountingSystem = new AccountingSystem();
    private Register register = new Register();
    private Sale sale;
    private Item item = new Item(0, null, 0);
    private Receipt receipt = new Receipt();
    private TotalRevenueFileOutputLogger totalRevenueFileOutputLogger = new TotalRevenueFileOutputLogger();

    /**
    * Creates a new sale instance.
    */
    public boolean createNewSale(){
        this.sale = new Sale();
        this.totalRevenueFileOutputLogger = new TotalRevenueFileOutputLogger();
        this.sale.addTotalRevenueObserver(new ConsoleTotalRevenueDisplay());
        if (this.sale == null) return false;
        return true;
    }

    /**
    * Lists the item(s) being sold by updating the inventory and sale information.
    *
    * @param itemID The scanned item's ID.
    * @param itemQuantity  The scanned item's quantity.
    * @return The sale information of the newly scanned item.
    */
    public SaleDTO enterItem(int itemID, int itemQuantity) throws NoItemIDFoundException{
        try {
            item = inventorySystem.fetchItem(itemID);
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
            return null;
        }

        if (item == null) return null;

        this.sale.listSoldItem(item, itemQuantity);

        return this.sale.fetchSalelnfo();
    }
    
    /**
    * Handles the customer's payment of the sale.
    *
    * @param paidAmount The customer's payment amount for the sale.
    */
    public double enterPayment(double paidAmount){
        this.sale.saleInfo.change = paidAmount - this.sale.totalPrice;

        if (this.sale.saleInfo.change > 0) { 
            register.increaseAmount(paidAmount - this.sale.change);
        } else {
            register.increaseAmount(paidAmount);
        }

        this.sale.notifyObservers(); // hm

        return paidAmount;
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
        
        
        if (sale.soldItems != null) {
            accountingSystem.recordSoldItem(sale.soldItems);
            inventorySystem.updateInventory(sale.soldItems);
        }

        totalRevenueFileOutputLogger.log("The sale " + this.sale.saleInfo.saleTime + " has ended. The total revenue is: " + this.sale.totalPrice + " SEK.");

        return this.sale.totalPrice;
    } 
    
    /**
    * Prints the receipt of the sale.
    */
    public boolean print() {
        boolean receiptPrinted = receipt.printReceipt(this.sale);
    
        return receiptPrinted;
    }
}
