package model;

import util.DBHelper;

public class Mocha extends ToppingDecorator {

	String name = "Mocha";
	
	public Mocha(Coffee newCoffee) {
		super(newCoffee);
	}

	public String getDescription() {
		return tempCoffee.getDescription() + ", " + name;
	}

	public double getPrice() {
		return tempCoffee.getPrice() + DBHelper.getPriceByName("coffeeToppings", name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static Coffee addMocha(Coffee coffee) {
		Coffee newCoffee = new Mocha(coffee);
		return newCoffee;
	}

}
