package model;

public class CoffeeMaker {
	
	Coffee baseCoffee;
	
	public CoffeeMaker(Coffee baseCoffee) {
		this.baseCoffee = baseCoffee;
	}
	
	public Coffee getCoffee() {
		return baseCoffee;
	}
	
	
}
