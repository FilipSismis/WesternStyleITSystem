package control;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Price;
import model.PriceType;	
import db.DBPrice;

public class ControlPrice {
	private DBPrice dbPrice;

	public ControlPrice() {
		this.dbPrice = new DBPrice();
	}
	
	public double findPriceByProductId(int productId)throws SQLException {
		List<Price> priceList = new ArrayList();
		Price finalPrice = null;
		double priceValue;
		priceList = dbPrice.findPriceByProductId(productId);
		for(int i = 0; i <= priceList.size()-1; i++) {
			Price price = priceList.get(i);
			if(price.getPriceType() == PriceType.SalesPrice) {
				finalPrice = price;
			}
		}
		priceValue = finalPrice.getPrice();
		return priceValue;
	}
	
}