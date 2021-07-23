package com.bridgelabz;


	import org.junit.Assert;
	import org.junit.Before;
	import org.junit.Test;

	public class InvoiceServiceTest {
	    InvoiceGenerator invoiceGenerator = null;

	      // To create object before any test case is called.
   
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
	}
