package model;

public class OrderLine {

	private int quantity;
	private Product product;
	private int id;

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	
	public OrderLine(int id, int quantity, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public Product getProduct() {
		return this.product;
	}
}
