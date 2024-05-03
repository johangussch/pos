/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.integration;
import se.kth.iv1350.pos.model.*;

/**
* The receipt containing the required information about the sale.
*/

public class Receipt {
    /**
     * Prints the receipt of the sale.
     * 
     * @param sale The information of the entire sale.
	 */
    public void printReceipt(Sale sale){
        System.out.println("\n- - - - - - - - - - - - - - - - - - Begin receipt - - - - - - - - - - - - - - - - - - -");
        System.out.println("Time of Sale : " + sale.saleTime + "\n");

        for (int i = 0; i < sale.soldItems.size(); i++) {
            Item item = sale.soldItems.get(i);
            System.out.println(item.itemDTO.itemName + " " + item.itemQuantity + " x " + item.itemDTO.itemPrice + " " + item.itemDTO.itemPrice * item.itemQuantity + " SEK");
        }

        System.out.println("\nObject-Oriented Design, IV1350 Seminar 3, Implementation");
        System.out.println("Total : " + sale.totalPrice + " SEK");
        System.out.println("VAT : " + sale.totalVAT + " SEK");

        System.out.println("\nCash: " + sale.paidAmount + " SEK");
        System.out.println("Change: " + (sale.paidAmount - sale.totalPrice) + " SEK");
        System.out.println("- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - - -");
    
        System.out.println("\nChange to give back to customer : " + (sale.paidAmount - sale.totalPrice) + " SEK");
    }
}