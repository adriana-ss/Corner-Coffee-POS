package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Coffee;
import model.Food;
import model.HamSandwich;
import model.Mocha;
import model.Order;
import model.Sale;
import model.Soy;
import model.SteamedMilk;
import model.WhippedMilk;
import util.DBHelper;

public class OrderMenuController {
	
	@FXML
	Button houseBlend;
	@FXML
	Button darkRoast;
	@FXML
	Button decaf;
	@FXML
	Button espresso;
	@FXML
	CheckBox steamedMilk;
	@FXML
	CheckBox soy;
	@FXML
	CheckBox mocha;
	@FXML
	CheckBox whippedMilk;
	@FXML
	ListView<String> orderView;
	@FXML
	Label subtotalLbl;
	@FXML
	Label taxLbl;
	@FXML
	Label totalLbl;
	@FXML
	GridPane toppingsMenu;
	@FXML
	Button reprintBtn;
	
	Food foodInProgress;
	Order orderInProgress = new Order();
	
	@FXML
	public void placeOrder() {
		System.out.println("***ORDER PLACED***");
		Sale sale = new Sale(orderInProgress);
		saveSale(sale);
		reprintBtn.setDisable(false);
	}
	
	private void saveSale(Sale sale) {
		DBHelper.saveSale(sale);
		Sale.writeToSalesFile(sale);
		sale.printRecepipt();
	}

	@FXML
	public void reprintReceipt() {
		System.out.println("***REPRINT***");
		Sale sale = new Sale(orderInProgress);
		sale.printRecepipt();
	}
	
	@FXML
	public void startNewOrder() {
		foodInProgress = null;
		orderInProgress = new Order();
		updateDisplay();
		resetSelections();
		reprintBtn.setDisable(true);
	}
	
	@FXML
	public void addItem() {
		if(foodInProgress == null) {
			return;
		}
		
		if(foodInProgress instanceof Coffee) {
			foodInProgress = addToppings((Coffee)foodInProgress);
		}
		
		orderInProgress.add(foodInProgress);
		updateDisplay();
		resetSelections();
		foodInProgress = null;
	}
	
	private void resetSelections() {
		steamedMilk.setSelected(false);
		soy.setSelected(false);
		mocha.setSelected(false);
		whippedMilk.setSelected(false);
		toppingsMenu.setDisable(true);
		
	}

	private void updateDisplay() {
		orderView.getItems().clear();
		orderView.getItems().addAll(orderInProgress.getFoodDescriptions());
		updateCosts();
	}

	private void updateCosts() {
		subtotalLbl.setText(Double.toString(orderInProgress.getSubtotal()));
		taxLbl.setText(orderInProgress.getTax() + "");
		totalLbl.setText(orderInProgress.getTotal() + "");
	}
	
	@FXML
	public void addSandwich() {
		foodInProgress = new HamSandwich();
	}

	@FXML
	public void startCoffee(Event event) {
		Coffee coffee = MenuHelper.getSelectedCoffee(event);
		coffee = addToppings(coffee);
		foodInProgress = coffee;
		if(foodInProgress != null) {
			toppingsMenu.setDisable(false);
		}
	}
	
	public Coffee addToppings(Coffee coffee) {
		if(steamedMilk.isSelected()) {
			coffee = SteamedMilk.addSteamedMilk((Coffee)coffee);
		}
		if(soy.isSelected()) {
			coffee = Soy.addSoy((Coffee)coffee);
		}
		if(mocha.isSelected()) {
			coffee = Mocha.addMocha((Coffee)coffee);
		}
		if(whippedMilk.isSelected()) {
			coffee = WhippedMilk.addWhippedMilk((Coffee)coffee);
		}
		
		return (Coffee)coffee;
	}
	
	@FXML
	public void voidOrder() {
		startNewOrder();
	}
	
	@FXML
	public void printSales() {
		DBHelper.viewSaleRecords();
	}
	
	
}
