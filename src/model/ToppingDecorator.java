package model;

public class ToppingDecorator implements Coffee {

	protected Coffee tempCoffee;
	
	public ToppingDecorator(Coffee newCoffee) {
		tempCoffee = newCoffee;
	}
	
	@Override
	public String getDescription() {
		return tempCoffee.getDescription();
	}

	@Override
	public double getPrice() {
		return tempCoffee.getPrice();
	}

}
