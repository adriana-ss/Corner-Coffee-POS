package model;

import java.text.DecimalFormat;
import java.util.Date;

public class Sale {
	Order order;
	Date date;
	double subtotal;
	double tax;
	double total;
	PaymentMethod paymentMethod;
	String employeeID;
	
	DecimalFormat df = new DecimalFormat("#0.00");

	public Sale(Order order, PaymentMethod paymentMethod, String employeeID) {
		super();
		this.order = order;
		this.date = new Date();
		this.subtotal = order.getSubtotal();
		this.tax = order.getTax();
		this.total = order.getTotal();
		this.paymentMethod = paymentMethod;
		this.employeeID = employeeID;
	}

	public Sale(Order order) {
		super();
		this.order = order;
		this.date = new Date();
		this.subtotal = order.getSubtotal();
		this.tax = order.getTax();
		this.total = order.getTotal();
	}

	public Order getOrder() {
		return order;
	}

	public Date getDate() {
		return date;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getTax() {
		return tax;
	}

	public double getTotal() {
		return total;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	@Override
	public String toString() {
		return "Sale [order=" + order + ", date=" + date + ", subtotal=" + subtotal + ", tax=" + tax + ", total="
				+ total + ", paymentMethod=" + paymentMethod + ", employeeID=" + employeeID + "]";
	}

	public String getReceipt() {
		return "Date: " + date +
				"\tServer ID: " + employeeID +
				"\n\nOrder: \n" + order.getReceipt() +
				"\nSubtotal: \t$" + df.format(subtotal) +
				"\nTax: \t\t$" + df.format(tax) +
				"\nTotal: \t\t$" + df.format(total);
	}

	public void printRecepipt() {
		System.out.println(getReceipt());
	}






}
