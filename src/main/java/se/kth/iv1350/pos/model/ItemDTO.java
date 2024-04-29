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
    public String itemDescription;
    public float itemPrice;
    public float itemVAT;
    
    public ItemDTO(String itemDescription, float itemPrice, float itemVAT){
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
    }

    public String fetchItemDescription(){
        return this.itemDescription;
    }
    
    public float fetchItemPrice(){
        return this.itemPrice;
    }
    
    public float fetchItemVAT(){
        return this.itemVAT;
    }
}