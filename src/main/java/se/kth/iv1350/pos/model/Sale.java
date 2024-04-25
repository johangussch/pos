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
    private LocalTime saleTime;
    public SaleDTO saleInfo;
    public float runningTotal;
    public float totalPrice;
    public float totalVAT;
    public List<Item> items;
    
    public Sale() {
        this.saleTime = LocalTime.now();
        this.saleInfo = new SaleDTO(saleTime, 0, 0, null, 0);
        this.items = new ArrayList<>();
    }
    
    public float fetchRunningTotal(){
        return this.runningTotal;
    }
    public SaleDTO fetchSalelnfo(){
        return this.saleInfo;
    }
    public float fetchTotalPrice(){
        return this.totalPrice;
    }
    public void listSoldltem(Item item, int itemQuantity){
        this.items.add(item);
    }
    public List<Item> fetchItems(){
        return this.items;
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
