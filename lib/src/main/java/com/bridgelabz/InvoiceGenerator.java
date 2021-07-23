package com.bridgelabz;

public class InvoiceGenerator {

	private static double MINIMUM_COST_PER_KM = 10.0;
    private static int COST_PER_TIME = 1;
    private static double MINIMUM_FARE = 5;

      // If minimum total fare is less than the MINIMUM_FARE, return MINIMUM_FARE
     
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;

        return Math.max(totalFare, MINIMUM_FARE);
    }

       //  Return aggregate total fare for all the journey
    
    public double calculateTotalFare(Ride[] rides) {
        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
    // Calculate the average fare per ride

   public InvoiceSummary calculateFareSummary(Ride[] rides) {
       double totalFare = 0.0;
       for(Ride ride : rides) {
           totalFare += this.calculateFare(ride.distance, ride.time);
       }
       return new InvoiceSummary(rides.length, totalFare);
   }
}
