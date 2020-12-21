package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.Sale;
import util.ConnectionUtil;

public class DBHelper {

	public static double getPriceByName(String table, String itemName) {
		Connection conn = null;
		conn = ConnectionUtil.getConnection();

		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);

			ResultSet rs = statement.executeQuery("SELECT price " + 
					"  FROM " + table + 
					"  WHERE name = '" + itemName +"'");
			while(rs.next()) {
				String price = rs.getString("price");
				return Double.valueOf(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(conn);
		}


		return 0;
	}

	public static void saveSale(Sale sale) {
		Connection conn = null;
		conn = ConnectionUtil.getConnection();

		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("INSERT INTO sales (date, paymentMethod, subtotal, tax, total, employeeID)"
					+ "VALUES('" + sale.getDate() + "', '" + sale.getPaymentMethod() +
					"', '" + sale.getSubtotal() + "', '" + sale.getTax() + "', '" +
					sale.getTotal() + "', '" + sale.getEmployeeID() + "')" );
			
			System.out.println("Inserting sale: " + sale);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(conn);
		}

	}
	
	public static void viewSaleRecords() {
		Connection conn = null;
		conn = ConnectionUtil.getConnection();
		
		System.out.println("Viewing sales table");
		
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);

			ResultSet rs = statement.executeQuery("SELECT * FROM sales");
			
			while(rs.next()) {
				String date = rs.getString("date");
				System.out.println("Date: " + date);
				String paymentMethod = rs.getString("paymentMethod");
				System.out.println("Payment method: " + paymentMethod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(conn);
		}
	}
	
	public static void resetSales() {
		Connection conn = null;
		conn = ConnectionUtil.getConnection();

		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("DELETE FROM sales;");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(conn);
		}

	}
	
	


}
