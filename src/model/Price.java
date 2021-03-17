package model;

import java.util.Date;

public class Price {
	
	//fields for class Price
	private double price;
	private Date startDateTime;
	private PriceType type;
	
	public Price(double price, PriceType type) {
		this.price = price;
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setStartDateTime(Date date) {
		this.startDateTime = date;
	}
	
}
