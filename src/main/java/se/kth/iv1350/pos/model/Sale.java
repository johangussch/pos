/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

import java.time.LocalTime;

/**
*
 */
public class Sale {
    private LocalTime saleTime;
    public SaleDTO saleInfo;
    public ItemDTO[] boughtItems;
    public ItemDTO soldItem;
    public float runningTotal;
    public float totalPrice;
    public float totalVAT;
    
    
    public Sale() {
        saleTime = LocalTime.now();
        this.saleInfo = new SaleDTO(saleTime, 0, 0, null, 0);
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
    public ItemDTO[] fetchBoughtltems(){
        return this.boughtItems;
    }
    public void listSoldltem(Item item, int itemQuantity){
        
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
