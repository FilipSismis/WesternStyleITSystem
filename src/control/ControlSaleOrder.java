package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import db.*;
import model.*;

public class ControlSaleOrder {
	
	private ControlPrice controlPrice;
	private ControlCustomer controlCustomer;
	private ControlProduct controlProduct;
	private ControlInvoice controlInvoice;
	private DBOrderLine dbOrderLine;
	private DBSaleOrder dbSaleOrder;
	private SaleOrder saleOrder;
	
	public ControlSaleOrder() {
		this.controlPrice = new ControlPrice();
		this.controlCustomer = new ControlCustomer();
		this.controlProduct = new ControlProduct();
		this.controlInvoice = new ControlInvoice();
		this.dbOrderLine = new DBOrderLine();
		this.dbSaleOrder = new DBSaleOrder();
	}	
	
	public void createSaleOrder(String customerEmail)throws SQLException {
		Customer customer = controlCustomer.findCustomerbyEmail(customerEmail);
		saleOrder = new SaleOrder(customer);
		dbSaleOrder.addSaleOrder(saleOrder);
	}
	
	public int addProduct(String productCode, int quantity)throws SQLException {
		Product product = controlProduct.buildProductByProductCode(productCode);
		int currentStock = controlProduct.getCurrentStock(product);
		if(currentStock >= quantity) {
			OrderLine orderLine = new OrderLine(quantity, product);
			dbOrderLine.addOrderLine(orderLine, saleOrder.getId());
			controlProduct.updateCurrentStock(product.getProductCode(), quantity);
			return 1;
		}else {
			//incorrect amount requested to be added into orderLine
			return 0;
		}
	}
	
	public void finishOrder(String invoiceNo)throws SQLException {
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList = buildOrderLineList(dbOrderLine.findOrderLineBySaleOrderId(saleOrder.getId()));
		for(int i = 0; i <= orderLineList.size()-1; i++) {
			OrderLine orderLine = orderLineList.get(i);
			int quantity = orderLine.getQuantity();
			double price = controlPrice.findPriceByProductId(orderLine.getProduct().getId());
			saleOrder.addToTotal(price, quantity);
		}
		saleOrder.checkDiscount();
		double totalPrice = saleOrder.getTotal();
		controlInvoice.createInvoice(invoiceNo, totalPrice);
	}
	
	private List<OrderLine> buildOrderLineList(ResultSet rs)throws SQLException {
		ArrayList<OrderLine> orderLineList = new ArrayList<>();
		while(rs.next()) {
			OrderLine orderLine = buildOrderLine(rs);
			orderLineList.add(orderLine);
		}
		return orderLineList;
	}
	
	private OrderLine buildOrderLine(ResultSet rs)throws SQLException {
		OrderLine orderLine = null;
		orderLine = new OrderLine(rs.getInt("quantity"), controlProduct.buildProductByProductId(rs.getInt("productId")));
		return orderLine;
	}
	
	
	
}
