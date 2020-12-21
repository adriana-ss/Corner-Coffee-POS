package model;

import util.DBHelper;

public class HouseBlend implements Coffee {

	String name = "House Blend";
	
	@Override
	public String getDescription() {
		return "House Blend";
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
		return "HouseBlend [name=" + name + "]";
	}

}
