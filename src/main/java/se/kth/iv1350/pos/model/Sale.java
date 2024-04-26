/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.*;

/**
*
 */
public class Sale {
    public LocalTime saleTime;
    public SaleDTO saleInfo;
    public float runningTotal;
    public float totalPrice;
    public float totalVAT;
    public List<Item> scannedItems;
    
    public Sale() {
        this.saleTime = LocalTime.now().withNano(0);
        this.saleInfo = new SaleDTO(saleTime, 0, 0, null, 0);
        this.scannedItems = new ArrayList<>();
    }
    
    public float fetchRunningTotal(){
        return this.runningTotal;
    }

    public SaleDTO fetchSalelnfo(){
        return this.saleInfo;
    }

    public void listSoldltem(Item item, int itemQuantity){
        if (scannedItems.contains(item)) {
            for (Item scannedItem : scannedItems) {
                if (scannedItem.fetchItemID() == (item.fetchItemID())) {
                    scannedItems.set(scannedItems.indexOf(scannedItem), new Item(item.fetchItemID(), item.fetchItemDTO(), scannedItem.fetchItemQuantity() + itemQuantity));
                }
            }
        } else {
            this.scannedItems.add(item);
        }
    }
    
    public List<Item> fetchItems(){
        return this.scannedItems;
    }
    
    /* 
    
    POTENTIELLA METODER ATT LÄGGA TILL:
    
    updatetotalprice
    updatetotalvat
    updateitems
    getreceipt
    isduplicateitem (alternatieve flow 3b)
    additem
    getsaleinfo
    *getcustomeritemsquantity*
    getitems
    
    */
}
