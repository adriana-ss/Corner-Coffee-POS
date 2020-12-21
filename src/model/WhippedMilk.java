package model;

import util.DBHelper;

public class WhippedMilk extends ToppingDecorator{

	String name = "Whipped Milk";
	
	public WhippedMilk(Coffee newCoffee) {
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
	
	public static Coffee addWhippedMilk(Coffee coffee) {
		Coffee newCoffee = new WhippedMilk(coffee);
		return newCoffee;
	}

}
