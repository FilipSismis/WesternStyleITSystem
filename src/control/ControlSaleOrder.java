package control;

import model.*;

public class ControlSaleOrder {
	private ControlPrice controlPrice;
	private ControlCustomer controlCustomer;
	private ControlProduct controlProduct;
	private ControlInvoice controlInvoice;
	private DBOrderLine dbOrderLine;
	private DBSaleOrder dbSaleOrder;
	
	public ControlSaleOrder() {
		this.controlPrice = new ControlPrice();
		this.controlCustomer = new ControlCustomer();
		this.controlProduct = new ControlProduct();
		this.controlInvoice = new ControlInvoice();
		
//		 public void createSaleOrder(String customerEmail) {
			
//		}
		
	}
}
