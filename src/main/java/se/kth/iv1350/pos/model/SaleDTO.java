/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

import java.util.*;

/**
* Represents a sale's information in the store.
 */
public class SaleDTO {
    public String saleTime;
    public double totalPrice;
    public double totalVAT;
    public List<Item> items;
    public double runningTotal;
    public double change;
 
    /**
     * Creates an instance of a sale with the specified parameters.
     * @param saleTime The time of the sale.
     * @param totalPrice The total price of the sale.
     * @param totalVAT The total VAT of the sale.
     * @param items The items of the sale.
     * @param runningTotal The running total of the sale.
     */
    public SaleDTO(String saleTime, double runningTotal, double totalVAT, List<Item> items, double totalPrice, double change) {
        this.saleTime = saleTime;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.items = items;
        this.runningTotal = runningTotal;
        this.change = change;
    }
    
    /**
     * Fetches the time of the sale.
     * @return The time of the sale.
     */
    public String fetchSaleTime(){
        return this.saleTime;
    }
    
    /**
     * Fetches the total price of the sale.
     * @return The total price of the sale.
     */
    public double fetchTotalPrice(){
        return this.totalPrice;
    }
    
    /**
     * Fetches the total VAT of the sale.
     * @return The total VAT of the sale.
     */
    public double fetchTotalVAT(){
        return this.totalVAT;
    }
}
