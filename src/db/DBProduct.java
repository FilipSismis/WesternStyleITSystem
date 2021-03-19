package db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import model.OrderLine;
import model.Product;

public class DBProduct{

	public DBProduct() {
		
	}
	
	public ResultSet findProductByProductId(int id) throws SQLException {
		ResultSet rs = null;
		String sql = String.format("select * from Product where id = %d",id);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			rs = s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return rs;
	}
	
	public ResultSet findProductByProductCode(String productCode) throws SQLException{
		ResultSet rs = null;
		String sql = String.format("select * from Product where productCode = '%s'",productCode);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			rs = s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return rs;
	}

	

	public void updateCurrentStock(String productCode, int quantity) throws SQLException {
		String sql = String.format("update Product set quantity = %d where productCode = '%s'", quantity, productCode);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
	}

}
