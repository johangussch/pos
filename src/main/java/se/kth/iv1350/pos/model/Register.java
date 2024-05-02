/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

/**
* Represents a register in the store.
 */
public class Register {
    public double amount;
   
    /*
     * Creates an instance of a register with the specified parameters.
     */
    public Register() {
        this.amount = 0;
    }
    
    /**
     * Fetches the amount of the register.
     * @param amount The amount of the register.
     **/
    public void increaseAmount(double amount){
        this.amount += amount;
    }
}
