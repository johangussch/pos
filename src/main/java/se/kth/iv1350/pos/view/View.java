/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;

/**
*
 */
public class View {
    private Controller contr;
    private Sale sale;
    
    public View(Controller contr){
        this.contr = contr;
    }
    
    public void runFakeExecution(){
        contr.createNewSale();
        System.out.println("A new bitch has been created!");

        System.out.println("Time of sale: " + sale.saleTime);
    }
}
