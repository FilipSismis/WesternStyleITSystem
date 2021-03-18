package control;

import model.Invoice;
import db.DBInvoice;
import java.sql.SQLException;

public class ControlInvoice {
private DBInvoice dbInvoice;

	public ControlInvoice() {
		dbInvoice = new DBInvoice();
	}
	
	public void createInvoice(String invoiceNo, double paidAmount)throws SQLException {
		Invoice invoice;
		invoice = new Invoice(invoiceNo, paidAmount);
		dbInvoice.addInvoice(invoice);
	}
}
