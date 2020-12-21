package junit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Coffee;
import model.HouseBlend;
import model.Soy;
import model.SteamedMilk;

class ToppingsTesting {

	@Test
	void test() {
		Coffee coffee = new HouseBlend();
		coffee = SteamedMilk.addSteamedMilk(coffee);
		System.out.println(coffee.getDescription());
		assertEquals(coffee.getPrice(), 2.50);		
	}
	
	@Test
	void test2() {
		Coffee coffee = new HouseBlend();
		coffee = SteamedMilk.addSteamedMilk(coffee);
		coffee = Soy.addSoy(coffee);
		System.out.println(coffee.getDescription());
		assertEquals(coffee.getPrice(), 3.25);		
	}

}
