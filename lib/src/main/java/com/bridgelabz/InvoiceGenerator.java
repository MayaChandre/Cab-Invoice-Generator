package com.bridgelabz;

public class InvoiceGenerator {


	private static double MINIMUM_COST_PER_KM = 10.0;
    private static int COST_PER_TIME = 1;
    private static double MINIMUM_FARE = 5;
    
     //  Return total fare for the journey,
               
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }
}