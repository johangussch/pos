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
     * Updates the amount in the register.
     * @param paidAmount The amount of the register.
     **/
    public void increaseAmount(double paidAmount){
        this.amount += paidAmount;
    }

    /**
     * Gets the amount in the register.
     * @return The amount in the register.
     **/
    public double fetchAmount(){
        return this.amount;
    }
}
