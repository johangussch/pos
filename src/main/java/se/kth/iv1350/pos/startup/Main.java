/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;

/**
*
 */
public class Main {
  
    public static void main(String[] args){
        Controller contr = new Controller();
        View view = new View(contr);
        
        Receipt receipt = new Receipt();
        InventorySystem inventorySystem = new InventorySystem();
        AccountingSystem accouningSystem = new AccountingSystem();
        Sale sale = new Sale();
        
        view.runFakeExecution();
    }
}
