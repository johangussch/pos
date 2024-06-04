/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.integration;
import java.util.*;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.util.*;

/**
* The database containing the items in the store.
 */
public class InventorySystem {
    private List<Item> storeItems = new ArrayList<>();
    private List<ItemDTO> itemDTOs = new ArrayList<>();
    private Logger fileLogger;
    private Logger screenLogger;

    public InventorySystem(){
        this.storeItems.add(new Item(1, new ItemDTO("Mjölk", "Milk 3% FAT", 10, 2), 5));
        this.storeItems.add(new Item(2, new ItemDTO("Bröd", "Bread LOW CALORIES", 20, 3), 5));
        this.itemDTOs.add(new ItemDTO("Mjölk", "Milk 3% FAT", 10, 2));
        this.itemDTOs.add(new ItemDTO("Bröd", "Bread LOW CALORIES", 20, 3));
        this.fileLogger = new FileLogger();
        this.screenLogger = new ScreenLogger();
    }

    /**
    * Fetches the information for the scanned item based on its ID.
    *
    * @param itemID The scanned item's ID.
    * @return The scanned item's information.
    * 
    * @throws NoItemIDFoundException If the item ID is not found in the inventory.
    */
    public Item fetchItem(int itemID) throws NoItemIDFoundException {

        for (Item item : storeItems){
            if (item.fetchItemID() == itemID) return item;
        }

        screenLogger.log("Item ID not found.");
        fileLogger.log("Item ID not found in InventorySystem");
        throw new NoItemIDFoundException("Item ID not found in InventorySystem.");
    }

    /**
    * Updates the store's inventory with a specified item.
    *
    * @param itemID The scanned item's ID.
    * @param newQuantity The new quantity of the already scanned item.
    */
    public void updateQuantity(int itemID, int newQuantity) throws NoItemIDFoundException, DatabaseConnectionException {
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
        System.out.println("Successfully recorded the sold items in Inventory System.");
    }
}