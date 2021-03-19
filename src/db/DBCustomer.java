package db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import model.Customer;
import model.CustomerType;

public class DBCustomer {
	
	private DBAddress dbAddress;
	
	public DBCustomer() {
		dbAddress = new DBAddress();
	}
	
	public Customer findCustomerByEmail(String customerEmail)throws SQLException {
		Customer customer = null;
		String sql = String.format("select * from Customer where email = '%s'",customerEmail);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			customer = buildCustomer(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return customer;	
	}
	
	private Customer buildCustomer(ResultSet rs)throws SQLException {
		CustomerType ct = CustomerType.valueOf(rs.getString("customerType"));
		dbAddress.getFullAddressByAddresId(rs.getInt("addressId"));
		Customer customer = new Customer(rs.getString("fName"), rs.getString("lName"), dbAddress.getAddress(), rs.getString("phoneNo"), rs.getString("email"), dbAddress.getZip(), dbAddress.getCity(), ct);
		customer.setId(rs.getInt("id"));
		return customer;
	}
}
