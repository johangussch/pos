/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.integration;
import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.Item;

/**
*
 */
public class InventorySystem {
    private Item[] storeItems = new Item[10];
    private ItemDTO[] itemDTOs = new ItemDTO[10];

    public InventorySystem(){
        
    }
    
    public Item fetchItem(int itemID){
        for (Item item : storeItems){
            if (item.fetchItemID() == itemID) return item;
        }
        return null;
    }

    public void calculatePrice(){

    }
    
    public void updateInventory(Sale sale){
    
    }
}
