package control;

import model.*;
import java.util.Scanner;

public class ControlCustomer {
private DBCustomer dbcustomer;

public void ControlProduct() {
	public Customer findCustomerbyEmail(String customerEmail) {
		return DBCustomer.getInstance().customer.get(customerEmail);
	}
}
}
