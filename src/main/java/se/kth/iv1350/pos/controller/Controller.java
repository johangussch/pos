/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.model.SaleDTO;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.Sale;

/**
*
 */
public class Controller {
    private InventorySystem inventorySystem;
    private Sale sale;
    private Item item;
    
    // KLAR
    public void createNewSale(){
        this.sale = new Sale();
    }
    
    public SaleDTO enterItem(int itemID, int itemQuantity){
        item = inventorySystem.fetchItem(itemID);

        if (item == null) return null;

        this.sale.listSoldltem(item, itemQuantity);
        this.sale.runningTotal += item.itemPrice * itemQuantity;

        SaleDTO saleInfo = this.sale.fetchSalelnfo();

        return saleInfo;
    }
    
    public void enterPayment(){
    
    }

    public float endSale(){
        float totalPrice = this.sale.fetchTotalPrice();

        return totalPrice;
    } 
    
    /*public ItemDTO fetchBoughtItems(){
    
    }*/
}
