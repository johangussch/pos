package se.kth.iv1350.pos.view;

public class ConsoleTotalRevenueDisplay implements TotalRevenueObserver {
    @Override
    public void newTotalRevenue(double totalRevenue) {
        System.out.println("The new total revenue is: " + totalRevenue + " SEK.");
    }
}