package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SaleOrder {
	private LocalDateTime saleDateTime;
	private double totalPrice;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private double discount;
	private Customer customer;
	private int id;
	
	public SaleOrder(Customer customer) {
		this.customer = customer;
		saleDateTime = LocalDateTime.now();
		totalPrice = 0;
	}
	
	public void addToTotal(int price, int quantity) {
		if (price  > 0 && quantity > 0){
		totalPrice += (price * quantity);
		} else {
			System.out.println( "Please enter valid input ");
		}
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDeliveryStatus(String status) {
		this.deliveryStatus = status;
	}
	
	public void setDeliveryDate(LocalDate date) {
		this.deliveryDate = date;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDeliveryStatus() {
		return this.deliveryStatus;
	}
	
	public LocalDate getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public LocalDateTime getDate() {
		return this.saleDateTime;
	}
	
	public double getTotal() {
		return totalPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	
}
