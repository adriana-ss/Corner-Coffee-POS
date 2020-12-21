package junit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.DBHelper;

class PriceTesting {

	@Test
	void test() {
		Double price = DBHelper.getPriceByName("coffeeToppings", "Steamed Milk");
		assertEquals(.50, price);
	}

}
