package control;

import model.*;
import java.sql.SQLException;
import db.*;

public class ControlCustomer {

	private DBCustomer dbCustomer;

	public void ControlCustomer() {
		dbCustomer = new DBCustomer();
	}
	
	public Customer findCustomerbyEmail(String customerEmail)throws SQLException {
		return dbCustomer.findCustomerByEmail(customerEmail);
	}
}
