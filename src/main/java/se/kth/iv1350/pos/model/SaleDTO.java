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
    public double totalPrice;
    public double totalVAT;
    public List<Item> items;
    public double runningTotal;
 
    public SaleDTO(String saleTime, double totalPrice, double totalVAT, List<Item> items, double runningTotal) {
        this.saleTime = saleTime;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.items = items;
        this.runningTotal = runningTotal;
    }
    
    public String fetchSaleTime(){
        return this.saleTime;
    }
    
    public double fetchTotalPrice(){
        return this.totalPrice;
    }
    
    public double fetchTotalVAT(){
        return this.totalVAT;
    }
}
