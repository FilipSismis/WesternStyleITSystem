package control;

import model.*;
import db.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlProduct {
	
	private DBProduct dbProduct;
	private ControlSupplier controlSupplier;
	
	public ControlProduct() {
		dbProduct = new DBProduct();
		controlSupplier = new ControlSupplier();
	}
		
	public Product buildProductByProductCode(String productCode)throws SQLException{
		Product product;
		ResultSet rs = dbProduct.findProductByProductCode(productCode);
		product = new Product(rs.getString("productCode"), rs.getString("pName"), rs.getInt("minStock"), rs.getInt("currentStock"), controlSupplier.findSupplierById(rs.getInt("supplierId")));
		product.setId(rs.getInt("id"));
		return product;		
	}
	
	public Product buildProductByProductId(int productId)throws SQLException{
		Product product;
		ResultSet rs = dbProduct.findProductByProductId(productId);
		product = new Product(rs.getString("productCode"), rs.getString("pName"), rs.getInt("minStock"), rs.getInt("currentStock"), controlSupplier.findSupplierById(rs.getInt("supplierId")));
		product.setId(productId);
		return product;		
	}
	
	
	public void updateCurrentStock(String productCode, int quantity)throws SQLException {
		dbProduct.updateCurrentStock(productCode, quantity);
	}
	
	public int getProductCurrentStock(Product product) {
		int currentStock = product.getCurrentStock();
		return currentStock;
	}
		
}
