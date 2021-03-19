package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import db.DBConnection;
import db.DBCustomer;

class DBConnectionTest {
	DBCustomer dbCustomer;
	
	@Before
	public void setUp() {
		dbCustomer = new DBCustomer();
	}
	
	@Test
	public void testGetConnection() {

		try {
			assertNotNull(DBConnection.getInstance().getConnection());
		} catch (Exception e) {
			fail("issues with dbconnection");
		}
	}
	
	@Test
	public void testfindCustomerByEmail() {

		try {
			assertNotNull(dbCustomer.findCustomerByEmail("filip.s@gmail.com"));
		} catch (Exception e) {
			fail("issues with dbconnection");
		}
	}

}
