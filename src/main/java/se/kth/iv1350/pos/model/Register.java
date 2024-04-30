/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.model;

/**
*
 */
public class Register {
    public double amount;
   
    public Register() {
        this.amount = 0;
    }
    
    public void increaseAmount(double amount){
        this.amount += amount;
    }
}
