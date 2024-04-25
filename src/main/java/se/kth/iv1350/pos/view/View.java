/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.*;

/**
*
 */
public class View {
    private Controller controller;
    private Sale sale;
    
    public View(Controller controller){
        this.controller = controller;
        this.sale = new Sale(); // Initialize the 'sale' object TEMPORÄR FÖR DET FUNKAR YEAH
    }


    public void runFakeExecution(){
        controller.createNewSale();
        System.out.println("A new bitch has been created!");
        
        System.out.println("Time of sale: " + sale.saleTime);
    }
}
