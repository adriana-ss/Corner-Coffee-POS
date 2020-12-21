package junit_testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Coffee;
import model.DarkRoast;
import model.Decaf;
import model.Food;
import model.HouseBlend;
import model.Order;
import model.PaymentMethod;
import model.Sale;
import model.Soy;
import model.SteamedMilk;
import util.DBHelper;

class OrderAndSaleTesting {

	List<Food> foods = new LinkedList<Food>();
	
	@Test
	void test() {
		foods.add(new DarkRoast());
		Order order = new Order(foods);
		assertEquals(order.getSubtotal(), 2.25);
	}
	
	@Test
	void testAdding() {
		foods.add(new DarkRoast());
		Order order = new Order(foods);
		Coffee coffee = new HouseBlend();
		coffee = SteamedMilk.addSteamedMilk(coffee);
		coffee = Soy.addSoy(coffee);
		order.add(coffee);
		assertEquals(order.getSubtotal(), 5.50);
	}
	
	@Test
	void testRemoving() {
		foods.add(new DarkRoast());
		Coffee decafCoffee = new Decaf();
		foods.add(decafCoffee);
		
		Order order = new Order(foods);
		order.remove(decafCoffee);
		assertEquals(order.getSubtotal(), 2.25);
	}
	
	@Test
	void testSalesSaving() {
		Coffee coffee1 = new HouseBlend();
		coffee1 = SteamedMilk.addSteamedMilk(coffee1);
		foods.add(coffee1);
		Order order = new Order(foods);
		Sale sale = new Sale(order, PaymentMethod.CASH, "12");
//		DBHelper.saveSale(sale);
		DBHelper.viewSaleRecords();
		assertEquals(sale.getSubtotal(), 2.50);
	}
	
	@Test 
	void receiptTest() {
		Order order = new Order(foods);
		Coffee coffee1 = new HouseBlend();
		coffee1 = SteamedMilk.addSteamedMilk(coffee1);
		order.add(coffee1);
		
		Coffee coffee2 = new Decaf();
		coffee2 = SteamedMilk.addSteamedMilk(coffee2);
		coffee2 = Soy.addSoy(coffee2);
		order.add(coffee2);
		
		order.printRecepipt();
		
	}
	}