package model;

import util.DBHelper;

public class Soy extends ToppingDecorator {

	String name = "Soy";
	
	public Soy(Coffee newCoffee) {
		super(newCoffee);
		System.out.println("Adding Soy. ");
	}
	
	public String getDescription() {
		return tempCoffee.getDescription() + ", Soy";
	}

	public double getPrice() {
		return tempCoffee.getPrice() + DBHelper.getPriceByName("coffeeToppings", name);
	}

	@Override
	public String toString() {
		return "Soy [name=" + name + "]";
	}
	
	public static Coffee addSoy(Coffee coffee) {
		coffee = new Soy(coffee);
		return coffee;
	}


}
