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
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Register register;
    private Sale sale;
    private Item item;
    private ItemDTO itemDTO;
    private Receipt receipt;
    
    public void createNewSale(){
        this.sale = new Sale();
    }
    
    public SaleDTO enterItem(int itemID, int itemQuantity){
        item = inventorySystem.fetchItem(itemID);

        if (item == null) return null;

        this.sale.listSoldltem(item, itemQuantity);
        this.sale.runningTotal += itemDTO.itemPrice * itemQuantity;
        this.sale.totalVAT += itemDTO.itemVAT * itemQuantity;
        
        return this.sale.fetchSalelnfo();
    }
    
    public void enterPayment(float paidAmount, List<Item> boughtItems){
        float change = paidAmount - this.sale.totalPrice;

        if (change > 0) { 
            register.increaseAmount(paidAmount - change);
        } else {
            register.increaseAmount(paidAmount);
        }
        
        accountingSystem.recordSoldItem(boughtItems);
        inventorySystem.updateInventory(boughtItems);

    }
    
    public float endSale(){
        this.sale.totalPrice = this.sale.runningTotal + this.sale.totalVAT;
        
        return this.sale.totalPrice;
    } 
    
    public void print() {
        receipt.printReceipt(this.sale);
    }

}
