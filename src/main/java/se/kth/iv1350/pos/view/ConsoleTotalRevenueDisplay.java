package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.TotalRevenueObserver;

public class ConsoleTotalRevenueDisplay implements TotalRevenueObserver {
    @Override
    public void printNewTotalRevenue(double totalRevenue) {
        System.out.println("The new total revenue is: " + totalRevenue + " SEK.");
    }
}