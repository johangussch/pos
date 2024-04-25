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
public class SaleDTO {
    public LocalTime saleTime;
    public float totalPrice;
    public float totalVAT;
    public Item[] items;
    public float runningTotal;
 
    public SaleDTO(LocalTime saleTime, float totalPrice, float totalVAT, Item[] items, float runningTotal) {
        this.saleTime = saleTime;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.items = items;
        this.runningTotal = runningTotal;
    }
    
    public LocalTime fetchSaleTime(){
        return this.saleTime;
    }
    
    public float fetchTotalPrice(){
        return this.totalPrice;
    }
    
    public float fetchTotalVAT(){
        return this.totalVAT;
    }
    
    public Item[] fetchItems(){
        return this.items;
    }
}
