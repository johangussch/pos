/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.NoItemIDFoundException;
import se.kth.iv1350.pos.integration.DatabaseConnectionException;
import se.kth.iv1350.pos.model.SaleDTO;

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
    
    public void runFakeExecution() throws NoItemIDFoundException DatabaseConnectionException{
        try {
            controller.createNewSale();
            SaleDTO saleInfo = controller.enterItem(1, 2);
            System.out.println("Add " + saleInfo.items.get(0).fetchItemQuantity() + " items with item id " + saleInfo.items.get(0).fetchItemID() + " :");
            System.out.println("Item ID : " + saleInfo.items.get(0).fetchItemID());
            System.out.println("Item Name : " + saleInfo.items.get(0).fetchItemDTO().fetchItemName());
            System.out.println("Item Cost : " + saleInfo.items.get(0).fetchItemDTO().fetchItemPrice() + " SEK");
            System.out.println("Item Description : " + saleInfo.items.get(0).fetchItemDTO().fetchItemDescription());
            System.out.println("\nTotal Cost ( incl VAT ): " + saleInfo.totalPrice + " SEK");
            System.out.println("Total VAT : " + saleInfo.totalVAT + " SEK");
            
            System.out.println("\nEnd Sale :");
            System.out.println("Total cost ( incl VAT ) : " + saleInfo.totalPrice + " SEK");
            double paidAmount = controller.enterPayment(100);
            System.out.println("\nCustomer pays " + paidAmount + " SEK :");
            controller.endSale(100);
            System.out.println("\nSent sale info to external accounting system.");
            System.out.println("Sent sale info to external inventory system.");
            controller.print();
    
            System.out.println("\n- - - - - - - - - - - - - - - - - - - Begin receipt - - - - - - - - - - - - - - - - - - -");
            System.out.println("Time of sale : " + saleInfo.saleTime + "\n");
            System.out.println(saleInfo.items.get(0).fetchItemDTO().fetchItemName() + " " + saleInfo.items.get(0).fetchItemQuantity() + " x " + saleInfo.items.get(0).fetchItemDTO().fetchItemPrice() + " " + saleInfo.items.get(0).fetchItemDTO().fetchItemPrice() * saleInfo.items.get(0).fetchItemQuantity() + " SEK");
            System.out.println("\nObject-Oriented Design, IV1350 Seminar 3, Implementation");
            System.out.println("Total : " + saleInfo.totalPrice + " SEK");
            System.out.println("VAT : " + saleInfo.totalVAT + " SEK");
    
            System.out.println("\nCash : " + paidAmount + " SEK");
            System.out.println("Change : " + saleInfo.change + " SEK");
            System.out.println("- - - - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - -");
            
            System.out.println("\nChange to give the customer : " + saleInfo.change + " SEK");
        } catch (NoItemIDFoundException | DatabaseConnectionException e) {
            System.out.println(e);
            logger.log(e);
            
        }
    }
}