package control;

import model.*;

public class ControlPrice {
private DBPrice dbprice;
private ControlProduct controlProduct;

public ControlPrice() {
	this.controlProduct = new ControlProduct();
	
	public Price findPriceByProductId(int productId) {
		return DBPrice.getInstance().price.get(productId);
	}
}
}
