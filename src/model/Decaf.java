package model;

import util.DBHelper;

public class Decaf implements Coffee {

	String name = "Decaf";
	
	@Override
	public String getDescription() {
		return "Decaf";
	}

	@Override
	public double getPrice() {
		return DBHelper.getPriceByName("coffees", name);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Decaf [name=" + name + "]";
	}
	
	
}
