/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.integration;
import se.kth.iv1350.pos.model.*;
import java.util.*;
/**
*
 */
public class AccountingSystem {
    public float balance;
    private List<Item> soldItems = new ArrayList<>();
    
    public AccountingSystem(){
        
    }
    
    public void recordSoldItem(List<Item> boughtItems){
        for (Item item : boughtItems) {
            soldItems.add(new Item(item.fetchItemID(), item.fetchItemDTO(), item.fetchItemQuantity()));
        }
    }
    
    public void updateBalance(float amount){
        this.balance += amount;
    }
}
