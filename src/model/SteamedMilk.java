package model;

import util.DBHelper;

public class SteamedMilk extends ToppingDecorator {

	String name = "Steamed Milk";
	
	public SteamedMilk(Coffee newCoffee) {
		super(newCoffee);
	}
	
	public String getDescription() {
		return tempCoffee.getDescription() + ", Steamed milk";
	}

	public double getPrice() {
		return tempCoffee.getPrice() + DBHelper.getPriceByName("coffeeToppings", name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static Coffee addSteamedMilk(Coffee coffee) {
		Coffee newCoffee = new SteamedMilk(coffee);
		return newCoffee;
	}

}
