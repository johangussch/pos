/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;

/**
* Represents the view of the program.
 */
public class View {
    
    public View(){
    }

    public Controller controller;
    
    /**
     * Creates an instance of a view with the specified parameters.
     * @param controller The controller used for all operations.
     */
    public View(Controller controller){
        this.controller = controller;
    }
    
    public void runFakeExecution(){
        controller.createNewSale();
        controller.enterItem(1, 2);
        controller.enterItem(2, 1);
        controller.enterItem(1, 4);
        controller.enterPayment(1000);
        controller.endSale(1000);
        controller.print();
    }
}