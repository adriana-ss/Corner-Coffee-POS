package model;

import util.DBHelper;

public class Soy extends ToppingDecorator {

	String name = "Soy";
	
	public Soy(Coffee newCoffee) {
		super(newCoffee);
	}
	
	public String getDescription() {
		return tempCoffee.getDescription() + ", Soy";
	}

	public double getPrice() {
		return tempCoffee.getPrice() + DBHelper.getPriceByName("coffeeToppings", name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static Coffee addSoy(Coffee coffee) {
		coffee = new Soy(coffee);
		return coffee;
	}


}
