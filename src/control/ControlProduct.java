package control;

import model.*;

public class ControlProduct {
private DBPrice dbprice;

public ControlProduct() {
	public Product findProductByProductId(String productId) {
		return DBProduct.getInstance().product.get(productId);
	}
	// public int getProductCurrentStock() {
		// String info = 
    	// return this.currentStock;
	// }
	public void updateCurrentStock(String productId, int quantity) {
		//
	}
	public String getProductId(Product product) {
		return DBProduct.getInstance().product.get(Product);
	}
}
}
