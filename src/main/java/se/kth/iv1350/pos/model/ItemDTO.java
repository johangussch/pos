/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

/**
* Represents an item's information in the inventory.
 */
public class ItemDTO {
    public String itemName;
    public String itemDescription;
    public double itemPrice;
    public double itemVAT;
    
    /*
     * Creates an instance of an item with the specified parameters.
     */
    public ItemDTO(String itemName, String itemDescription, double itemPrice, double itemVAT){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
    }

    /*
     * Fetches the name of the item.
     */
    public String fetchItemName(){
        return this.itemName;
    }

    /*
     * Fetches the description of the item.
     */
    public String fetchItemDescription(){
        return this.itemDescription;
    }
    
    /*
     * Fetches the price of the item.
     */
    public double fetchItemPrice(){
        return this.itemPrice;
    }
    
    /*
     * Fetches the VAT of the item.
     */
    public double fetchItemVAT(){
        return this.itemVAT;
    }
}