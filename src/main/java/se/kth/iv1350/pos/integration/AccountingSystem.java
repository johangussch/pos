/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.integration;
import se.kth.iv1350.pos.model.*;
import java.util.*;
/**
* The database with information containing the store's finances.
 */
public class AccountingSystem {
    public double balance;
    public List<Item> soldItems = new ArrayList<>();
    

    /**
     * Creates an instance of the accounting system with the specified parameters.
     */
    public AccountingSystem(){
        this.balance = 0;
    }

    /**
    * Records the sold items to be used when updating the accounting system.
    *
    * @param itemsToBeRecorded Items that should be recorded to soldItems.
    */
    public void recordSoldItem(List<Item> itemsToBeRecorded){
        for (Item item : itemsToBeRecorded) {
            this.soldItems.add(new Item(item.fetchItemID(), item.fetchItemDTO(), item.fetchItemQuantity()));
        }
    }
}
