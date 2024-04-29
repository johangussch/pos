/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

import java.util.*;

/**
*
 */
public class SaleDTO {
    public String saleTime;
    public float totalPrice;
    public float totalVAT;
    public List<Item> items;
    public float runningTotal;
 
    public SaleDTO(String saleTime, float totalPrice, float totalVAT, List<Item> items, float runningTotal) {
        this.saleTime = saleTime;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.items = items;
        this.runningTotal = runningTotal;
    }
    
    public String fetchSaleTime(){
        return this.saleTime;
    }
    
    public float fetchTotalPrice(){
        return this.totalPrice;
    }
    
    public float fetchTotalVAT(){
        return this.totalVAT;
    }
}
