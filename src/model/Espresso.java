package model;

import util.DBHelper;

public class Espresso implements Coffee{

	String name = "Espresso";
	
	@Override
	public String getDescription() {
		return "Espresso";
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
		return name;
	}

}
