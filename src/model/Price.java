package model;

import java.time.LocalDateTime;

public class Price {
	
	//fields for class Price
	private double price;
	private LocalDateTime startDateTime;
	private PriceType type;
	
	public Price(double price, PriceType type) {
		this.price = price;
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
		
	public PriceType getPriceType() {
		return this.type;
	}
	
}
