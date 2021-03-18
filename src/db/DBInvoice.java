package db;

import model.Invoice;
import java.sql.SQLException;

public class DBInvoice {

	public DBInvoice() {
		
	}
	
	public void addInvoice(Invoice invoice)throws SQLException {
		String sql = String.format("insert into Invoice (invoiceNo, paidAmount) values ('%d', %f)", invoice.getInvoiceNo(), invoice.getPaidAmount());
		DBConnection.getInstance().executeUpdate(sql);
	}
}
