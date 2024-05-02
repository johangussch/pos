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
* Represents a sale in the store.
 */
public class Sale {
    public String saleTime;
    public SaleDTO saleInfo;
    public double runningTotal;
    public double totalPrice;
    public double totalVAT;
    public List<Item> soldItems;
    public double paidAmount;

    /**
     * Creates an instance of a sale with the specified parameters.
     */
    public Sale() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.saleTime = LocalDateTime.now().withNano(0).format(formatter);
        this.saleInfo = new SaleDTO(saleTime, 0, 0, null, 0);
        this.soldItems = new ArrayList<>();
        this.runningTotal = 0;
    }
    
    /**
     * @return The total price of the sale.
     */
    public SaleDTO fetchSalelnfo(){
        return this.saleInfo;
    }

    /**
     * @return The total running price of the sale.
     */
    public double fetchRunningTotal(){
        return this.runningTotal;
    }

    /**
     * @return The total total price of the sale.
     */
    public double fetchTotalPrice() {
        return this.totalPrice;
    }

    /**
     * @return The total VAT of the sale.
     */
    public double fetchTotalVAT() {
        return this.totalVAT;
    }
    
    /**
     * Fetches the total price of the sale, and returns it.
     * @param item The item that is to be added to the sale.
     * @param itemQuantity The quantity of the item that is to be added to the sale.
     * @return The total price of the sale.
     */
    public void listSoldItem(Item item, int itemQuantity){
        for (Item scannedItem : soldItems) {
            this.totalVAT += item.fetchItemDTO().fetchItemVAT() * itemQuantity;
            this.runningTotal += item.fetchItemDTO().fetchItemPrice() * itemQuantity;
            this.totalPrice = this.runningTotal + this.totalVAT;
            
            if (scannedItem.fetchItemID() == (item.fetchItemID())) {
                soldItems.set(soldItems.indexOf(scannedItem), new Item(item.fetchItemID(), item.fetchItemDTO(), scannedItem.fetchItemQuantity() + itemQuantity));
                return;
            }
        }
        this.soldItems.add(item);
    }
    
    /**
     * @return Fetches the total price of the sale, and returns it.
     */
    public List<Item> fetchItems(){
        return this.soldItems;
    }
}
