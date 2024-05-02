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
    public Controller controller;
    
    /**
     * Creates an instance of a view with the specified parameters.
     * @param controller The controller used for all operations.
     */
    public View(Controller controller){
        this.controller = controller;
    }
}