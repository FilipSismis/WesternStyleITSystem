package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.CustomerType;

public class SaleOrder {
	private LocalDateTime saleDateTime;
	private double totalPrice;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private Customer customer;
	private int id;
	
	public SaleOrder(Customer customer) {
		this.customer = customer;
		saleDateTime = LocalDateTime.now();
		totalPrice = 0;
	}
	
	public void addToTotal(double price, int quantity) {
		totalPrice += (price * quantity);
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
	
	//discount amount for clubs is hard coded for now for 10% 
	public void checkDiscount() {
		if(customer.getType() == CustomerType.PERSON) {
			if(totalPrice < 2500) {
				totalPrice += 45;
			}
		}else if(customer.getType() == CustomerType.CLUB){
			if(totalPrice >= 1500) {
				totalPrice *= 0.90; 
			}
		}
	}
	
}
