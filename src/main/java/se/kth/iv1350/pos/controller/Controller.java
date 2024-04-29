/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import java.util.*;

/**
*
 */
public class Controller {
    private InventorySystem inventorySystem = new InventorySystem();
    private AccountingSystem accountingSystem = new AccountingSystem();
    private Register register = new Register();
    public Sale sale;
    private Item item = new Item(0, null, 0);
    private ItemDTO itemDTO = new ItemDTO(null, 0, 0);
    private Receipt receipt = new Receipt();
    
    public void createNewSale(){
        this.sale = new Sale();
    }
    
    public SaleDTO enterItem(int itemID, int itemQuantity){
        item = inventorySystem.fetchItem(itemID);

        if (item == null) return null;

        this.sale.listSoldItem(item, itemQuantity);
        this.sale.runningTotal += itemDTO.itemPrice * itemQuantity;
        this.sale.totalVAT += itemDTO.itemVAT * itemQuantity;
        
        return this.sale.fetchSalelnfo();
    }
    
    public float enterPayment(float paidAmount){
        float change = paidAmount - this.sale.totalPrice;

        if (change > 0) { 
            register.increaseAmount(paidAmount - change);
        } else {
            register.increaseAmount(paidAmount);
        }
        
        return change;
    }
    
    public float endSale(float paidAmount){
        this.sale.totalPrice = this.sale.runningTotal + this.sale.totalVAT;
        this.sale.paidAmount = paidAmount;
        if (sale.scannedItems != null) {
            accountingSystem.recordSoldItem(sale.scannedItems);
            inventorySystem.updateInventory(sale.scannedItems);
        }
        return this.sale.totalPrice;
    } 
    
    public void print() {
        receipt.printReceipt(this.sale);
    }
}
