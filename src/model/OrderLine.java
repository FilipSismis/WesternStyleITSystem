package model;

public class OrderLine {

	private int quantity;
	private Product product;

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
		
	public int getQuantity() {
		return this.quantity;
	}
	
	public Product getProduct() {
		return this.product;
	}
}
