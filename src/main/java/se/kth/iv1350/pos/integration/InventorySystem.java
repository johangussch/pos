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
        this.storeItems.add(new Item(1, new ItemDTO("Mommas Milk", "Milk 3% FAT", 10, 2), 10));
        this.storeItems.add(new Item(2, new ItemDTO("Daddys Bread", "Bread LOW CALORIES", 20, 3), 10));
        this.itemDTOs.add(new ItemDTO("Mommas Milk", "Milk 3% FAT", 10, 2));
        this.itemDTOs.add(new ItemDTO("Daddys Bread", "Bread LOW CALORIES", 20, 3));
    }

    /**
    * Fetches the information for the scanned item based on its ID.
    *
    * @param itemID The scanned item's ID.
    * @return The scanned item's information.
    */
    public Item fetchItem(int itemID){
        for (Item item : storeItems){
            if (item.fetchItemID() == itemID) return item;
        }
        return null;
    }

    /**
    * Updates the store's inventory with a specified item.
    *
    * @param itemID The scanned item's ID.
    * @param newQuantity The new quantity of the already scanned item.
    */
    public void updateQuantity(int itemID, int newQuantity){
        Item item = fetchItem(itemID);

        if (item != null) {
            storeItems.set(storeItems.indexOf(fetchItem(itemID)), new Item(itemID, fetchItem(itemID).fetchItemDTO(), newQuantity));
        }
    }

    /**
	 * Reduces the inventory's quantity of the items sold in the sale.
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
