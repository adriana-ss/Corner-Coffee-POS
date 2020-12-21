package model;

import util.DBHelper;

public class SteamedMilk extends ToppingDecorator {

	String name = "Steamed Milk";
	
	public SteamedMilk(Coffee newCoffee) {
		super(newCoffee);
		System.out.println("Adding steamed milk. ");
	}
	
	public String getDescription() {
		return tempCoffee.getDescription() + ", Steamed milk";
	}

	public double getPrice() {
		return tempCoffee.getPrice() + DBHelper.getPriceByName("coffeeToppings", name);
	}

	@Override
	public String toString() {
		return "SteamedMilk [name=" + name + "]";
	}
	
	public static Coffee addSteamedMilk(Coffee coffee) {
		Coffee newCoffee = new SteamedMilk(coffee);
		return newCoffee;
	}

}
