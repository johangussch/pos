/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.integration;
import java.util.*;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.ItemDTO;

/**
* The database containing the items in the store.
 */
public class InventorySystem {
    private List<Item> storeItems = new ArrayList<>();
    private List<ItemDTO> itemDTOs = new ArrayList<>();

    public InventorySystem(){
        this.storeItems.add(new Item(1, new ItemDTO("Milk", 10, 2), 10));
        this.storeItems.add(new Item(2, new ItemDTO("Bread", 20, 3), 10));
        this.itemDTOs.add(new ItemDTO("Milk", 10, 2));
        this.itemDTOs.add(new ItemDTO("Bread", 20, 3));
    }

    /**
    * Ends the sale instance, saving the total price and paid amount of the sale to  and updating
    *
    * @param boughtItems The customer's bought items are recorded to be used when ending the sale.
    * @return 
    */
    public Item fetchItem(int itemID){
        for (Item item : storeItems){
            if (item.fetchItemID() == itemID) return item;
        }
        return null;
    }

    public void updateQuantity(int itemID, int newQuantity){
        Item item = fetchItem(itemID);

        if (item != null) {
            storeItems.set(storeItems.indexOf(fetchItem(itemID)), new Item(itemID, fetchItem(itemID).fetchItemDTO(), newQuantity));
        }
    }

    /**
	 * Updates the inventory based on the items sold in the sale.
     * 
	 * @param items The items that are to be updated with in the inventory.
	 */
    public void updateInventory(List<Item> items){
        for (Item item : items){
            for (Item storeItem : storeItems){
                if (item.fetchItemID() == storeItem.fetchItemID()){
                    updateQuantity(item.fetchItemID(), storeItem.fetchItemQuantity() - item.fetchItemQuantity());
                }
            }
        }
    }
}
