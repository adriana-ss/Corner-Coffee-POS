package model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import util.MathUtil;

public class Order {
	List<Food> foodOrdered;
	double subtotal;
	double tax;
	double total;
	
	public Order(List<Food> foodOrdered) {
		this.foodOrdered = foodOrdered;
		this.subtotal = MathUtil.round(calculateSubtotal(), 2);
		this.tax = MathUtil.round(calculateTax(8.625), 2);
		this.total = subtotal + tax;
	}
	
	public Order() {
		this.foodOrdered = new LinkedList<Food>();
		this.subtotal = calculateSubtotal();
		this.tax = calculateTax(8.625);
		this.total = subtotal + tax;
	}
	
	public void add(Food food) {
		foodOrdered.add(food);
		updateCosts();
	}
	
	public void add(Collection<Food> food) {
		foodOrdered.addAll(food);
		updateCosts();
	}
	
	public void remove(Food food) {
		foodOrdered.remove(food);
		updateCosts();
	}
	
	public void clearOrder() {
		foodOrdered.clear();
		updateCosts();
	}
	
	public void updateCosts() {
		this.subtotal = calculateSubtotal();
		this.tax = calculateTax(8.625);
		this.total = subtotal + tax;
	}
	
	public double calculateSubtotal() {
		double subtotal = 0;
		
		for(Food food : foodOrdered) {
			subtotal += food.getPrice();
		}
		this.subtotal = subtotal;
		return subtotal;
	}
	
	public double calculateTax(double taxRate) {
		this.tax = MathUtil.round((taxRate/100) * subtotal, 2);
		return tax;
	}
	
	public double getTotal() {
		return total;
	}

	public List<Food> getFoodOrdered() {
		return foodOrdered;
	}
	
	public List<String> getFoodDescriptions() {
		LinkedList<String> list = new LinkedList<String>();
		for(Food food: foodOrdered) {
			list.add(food.getDescription());
		}
		return list;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getTax() {
		return tax;
	}

	@Override
	public String toString() {
		return "Order [\nfoodOrdered=" + foodOrdered +
				"\n subtotal=" + subtotal + "\n tax=" 
				+ tax + "\n total=" + total + "]";
	}
	
	public String getReceipt() {
		String receipt = "";
		for(Food food: foodOrdered) {
			receipt += food.getDescription();
			receipt += "\t" + food.getPrice();
			receipt += "\n";
		}
		return receipt;
	}
	
	public void printRecepipt() {
		System.out.println(getReceipt());
	}
	
	
}
