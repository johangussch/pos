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
        int itemAlreadyAdded = 0;
        for (Item scannedItem : this.soldItems) {
            if (scannedItem.fetchItemID() == (item.fetchItemID())) {
                this.soldItems.set(this.soldItems.indexOf(scannedItem), new Item(item.fetchItemID(), item.fetchItemDTO(), scannedItem.itemQuantity + itemQuantity));
                itemAlreadyAdded = 1;
            }
        }
        
        if (itemAlreadyAdded == 0) {
            this.soldItems.add(new Item(item.itemID, item.fetchItemDTO(), itemQuantity));
        }

        this.runningTotal += item.fetchItemDTO().fetchItemPrice() * itemQuantity;
        this.totalVAT += item.fetchItemDTO().fetchItemVAT() * itemQuantity;
        this.totalPrice = this.runningTotal + this.totalVAT;
        this.saleInfo = new SaleDTO(this.saleTime, this.runningTotal, this.totalVAT, this.soldItems, this.totalPrice);
    }
    
    /**
     * @return Fetches the total price of the sale, and returns it.
     */
    public List<Item> fetchItems(){
        return this.soldItems;
    }
}
