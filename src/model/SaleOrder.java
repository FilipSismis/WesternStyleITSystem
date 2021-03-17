package model;

import java.util.Date;

public class SaleOrder {
	private Date date;
	private double totalPrice;
	private String deliveryStatus;
	private Date deliveryDate;
	private double discount;
	private Customer customer;
	
	public SaleOrder(Customer customer) {
		this.customer = customer;
	}
	public void addToTotal(int price, int quantity, double totalPrice) {
		if (price  > 0 && quantity > 0){
		totalPrice = price * quantity;
		} else {
			System.out.println( "Please enter valid input ");
		}
	}
	public void setDeliveryStatus(String status) {
		this.deliveryStatus = status;
	}
	public void setDeliveryDate(Date date) {
		this.deliveryDate = date;
	}
	public String getDeliveryStatus() {
		return this.deliveryStatus;
	}
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}
}
