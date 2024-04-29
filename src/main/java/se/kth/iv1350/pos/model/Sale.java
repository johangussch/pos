/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
*
 */
public class Sale {
    public String saleTime;
    public SaleDTO saleInfo;
    public float runningTotal;
    public float totalPrice;
    public float totalVAT;
    public List<Item> scannedItems;
    public float paidAmount;


    public Sale() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.saleTime = LocalDateTime.now().withNano(0).format(formatter);
        this.saleInfo = new SaleDTO(saleTime, 0, 0, null, 0);
        this.scannedItems = new ArrayList<>();
        this.runningTotal = 0;
    }
    
    public float fetchRunningTotal(){
        return this.runningTotal;
    }

    public SaleDTO fetchSalelnfo(){
        return this.saleInfo;
    }

    public void listSoldItem(Item item, int itemQuantity){
        for (Item scannedItem : scannedItems) {
            this.totalVAT += item.fetchItemDTO().fetchItemVAT() * itemQuantity;
            this.runningTotal += item.fetchItemDTO().fetchItemPrice() * itemQuantity;
            this.totalPrice = this.runningTotal + this.totalVAT;
            if (scannedItem.fetchItemID() == (item.fetchItemID())) {
                scannedItems.set(scannedItems.indexOf(scannedItem), new Item(item.fetchItemID(), item.fetchItemDTO(), scannedItem.fetchItemQuantity() + itemQuantity));
                return;
            }
        }
        this.scannedItems.add(item);
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
