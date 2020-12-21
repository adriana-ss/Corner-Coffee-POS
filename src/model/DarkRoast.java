package model;

import util.DBHelper;

public class DarkRoast implements Coffee {

	String name = "Dark Roast";
	
	@Override
	public String getDescription() {
		return "Dark Roast";
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
