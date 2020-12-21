package controller;

import javafx.event.Event;
import javafx.scene.control.Control;
import model.Coffee;
import model.DarkRoast;
import model.Decaf;
import model.Espresso;
import model.HouseBlend;

public class MenuHelper {

	public static Coffee getSelectedCoffee(Event event) {
		String coffeeType = ((Control) event.getSource()).getId();
		switch(coffeeType) 
		{
		case "houseBlend":
			return new HouseBlend();
		case "darkRoast":
			return new DarkRoast();
		case "decaf":
			return new Decaf();
		case "espresso":
			return new Espresso();
		default:
			System.out.println("Coffee selection failed");
			return null;
		}
	}
	
	
}
