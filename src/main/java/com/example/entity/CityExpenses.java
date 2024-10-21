package com.example.entity;
	
	import java.util.HashMap;
	import java.util.Map;

	// Define a class to hold city expense data
	public class CityExpenses {
	    private double rentPercentage;
	    private double foodPercentage;
	    private double entertainmentPercentage;
	    private double savingsPercentage;
	    private double othersPercentage;

	    // Constructor
	    public CityExpenses(double rent, double food, double entertainment, double savings, double others) {
	        this.rentPercentage = rent;
	        this.foodPercentage = food;
	        this.entertainmentPercentage = entertainment;
	        this.savingsPercentage = savings;
	        this.othersPercentage = others;
	    }

	    // Getters
	    public double getRentPercentage() { return rentPercentage; }
	    public double getFoodPercentage() { return foodPercentage; }
	    public double getEntertainmentPercentage() { return entertainmentPercentage; }
	    public double getSavingsPercentage() { return savingsPercentage; }
	    public double getOthersPercentage() { return othersPercentage; }
	}

