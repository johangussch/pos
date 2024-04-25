/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

/**
*
 */
public class Item {
    public int itemID;
    public ItemDTO itemDTO;
    public int itemQuantity;
    
    public Item(int itemID, ItemDTO itemDTO, int itemQuantity){
        this.itemID = itemID;
        this.itemDTO = itemDTO;
        this.itemQuantity = itemQuantity;
    }
    
    public int fetchItemID(){
        return this.itemID;
    }
    
    public ItemDTO fetchItemDTO(){
        return this.itemDTO;
    }
    
    public int fetchItemQuantity(){
        return this.itemQuantity;
    }
}