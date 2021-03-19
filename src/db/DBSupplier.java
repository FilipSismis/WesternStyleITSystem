package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Supplier;


public class DBSupplier {
	
	private DBAddress dbAddress;
	
	public DBSupplier() {
		dbAddress = new DBAddress();
	}

	public Supplier findSupplierById(int supplierId)throws SQLException {
		Supplier supplier = null;
		String sql = String.format("select * from Supplier where id = %d",supplierId);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			supplier = buildSupplier(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return supplier;	
	}
	
	private Supplier buildSupplier(ResultSet rs)throws SQLException {
		dbAddress.getFullAddressByAddresId(rs.getInt("addressId"));
		Supplier supplier = new Supplier(rs.getString("sName"), rs.getString("phoneNo"), rs.getString("email"), dbAddress.getAddress(), dbAddress.getZip(), dbAddress.getCity(), dbAddress.getCountry());
		supplier.setId(rs.getInt("id"));
		return supplier;
	}
}

