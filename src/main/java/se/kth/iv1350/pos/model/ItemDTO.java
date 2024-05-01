/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

/**
*
 */
public class ItemDTO {
    public String itemName;
    public String itemDescription;
    public double itemPrice;
    public double itemVAT;
    
    public ItemDTO(String itemName, String itemDescription, double itemPrice, double itemVAT){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
    }

    public String fetchItemName(){
        return this.itemName;
    }

    public String fetchItemDescription(){
        return this.itemDescription;
    }
    
    public double fetchItemPrice(){
        return this.itemPrice;
    }
    
    public double fetchItemVAT(){
        return this.itemVAT;
    }
}