package com.bridgelabz;

  import java.util.Hashtable;
  import org.junit.Assert;
  import org.junit.Before;
  import org.junit.Test;

	public class InvoiceServiceTest {
	    InvoiceGenerator invoiceGenerator = null;
   
	    @Before
	    public void setUp() {
	        invoiceGenerator = new InvoiceGenerator();
	    }

	    @Test
	    public void givenDistanceAndTime_ShouldReturnTotalFare() {
	        double distance = 2.0;
	        int time = 5;
	        double fare = invoiceGenerator.calculateFare(distance,time);
	        Assert.assertEquals(25, fare, 0.0);
	    }

	    @Test
	    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
	        double distance = 0.1;
	        int time = 1;
	        double fare = invoiceGenerator.calculateFare(distance,time);
	        Assert.assertEquals(5, fare, 0.0);
	    }
	   
	    //return the aggregate total for all the rides
	     
	    @Test
	    public void givenMultipleRides_ShouldReturnTotalFare() {
	        Ride[] rides = { new Ride(2.0, 5),
	                new Ride(0.1, 1) };
	        double fare = invoiceGenerator.calculateTotalFare(rides);
	        Assert.assertEquals(30, fare, 0.0);
	    }
	    
	    //calculate the aggregate total for all the rides

	    @Test
	    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
	        Ride[] rides = { new Ride(2.0, 5),
	                new Ride(0.1, 1) };
	        InvoiceSummary summary = invoiceGenerator.calculateFareSummary(rides);
	        InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 30);
	        Assert.assertEquals(expectdInvoiceSummary, summary);
	    }
	    
	    // return the final invoice for particular userID
	    
	    @Test
	    public void givenUserID_ShouldReturnInvoiceSummary() {
	        Hashtable<Integer, Ride[]> htable = new Hashtable<>();

	        int userID1 = 1;
	        Ride[] ride1 = { new Ride(2.0, 5),
	                new Ride(0.1, 1) };
	        htable.put(userID1, ride1);

	        int userID2 = 2;
	        Ride[] ride2 = { new Ride(4.0, 10),
	                new Ride(1, 1) };
	        htable.put(userID2, ride2);

	        int userID = 2;

	        if(htable.containsKey(userID)) {
	            InvoiceSummary summary = invoiceGenerator.calculateFareSummary(htable.get(userID));
	            InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 61);
	            Assert.assertEquals(expectdInvoiceSummary, summary);
	        }
	    }
	}

