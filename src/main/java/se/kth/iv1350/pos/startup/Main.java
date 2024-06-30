/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.DatabaseConnectionException;
import se.kth.iv1350.pos.integration.NoItemIDFoundException;
import se.kth.iv1350.pos.view.View;

/**
* The main class which starts the program.
 */
public class Main {
    /**
     * The main method which starts the program.
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) throws NoItemIDFoundException, DatabaseConnectionException{
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
    }
}
