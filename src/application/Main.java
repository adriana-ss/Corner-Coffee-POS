package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import util.DBHelper;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/OrderMenuView.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBHelper.insertRow("sandwiches", "Ham Sandwich", 5.00);
		DBHelper.insertRow("coffees", "Espresso", 3.00);
		DBHelper.insertRow("coffeeToppings", "Mocha", 1.00);
		DBHelper.insertRow("coffeeToppings", "Whipped Milk", 0.50);
		launch(args);

		
	}
}
