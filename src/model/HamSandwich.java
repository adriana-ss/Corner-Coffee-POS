package model;

import util.DBHelper;

public class HamSandwich implements Sandwich {

	String name = "Ham Sandwich";
	
	@Override
	public String getDescription() {
		return name;
	}

	@Override
	public double getPrice() {
		return DBHelper.getPriceByName("sandwiches", name);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

}
