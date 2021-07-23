package com.bridgelabz;

public class InvoiceGenerator {

	private static final int PREMIUMRIDE = 0;
	private static final int NORMALRIDE = 0;
	private static double MINIMUM_COST_PER_KM1 = 10.0;
    private static int COST_PER_TIME1 = 1;
    private static double MINIMUM_FARE = 0;

      // If minimum total fare is less than the MINIMUM_FARE, return MINIMUM_FARE
    
       public double calculateFare(double distance, int time, int option) {
 
     // For Normal Ride
        
        if(option == NORMALRIDE) {
            MINIMUM_COST_PER_KM1 = 10.0;
            COST_PER_TIME1 = 1;
            MINIMUM_FARE = 5;
        }

        // For Premium Ride
         
        else if(option == PREMIUMRIDE) {
            MINIMUM_COST_PER_KM1 = 15.0;
            COST_PER_TIME1 = 2;
            MINIMUM_FARE = 20;
        }

        double totalFare = distance * MINIMUM_COST_PER_KM1 + time * COST_PER_TIME1;
        return Math.max(totalFare, MINIMUM_FARE);
    }
        // Return aggregate total fare for all the journey
     
    public double calculateTotalFare(Ride[] rides, int option) {
        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, option);
        }
        return totalFare;
    }

       // Calculate aggregate total fare for all the journey
               
    public InvoiceSummary calculateFareSummary(Ride[] rides, int option) {
        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, option);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}