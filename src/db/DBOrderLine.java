package db;

import java.sql.ResultSet;
import java.sql.Statement;

import model.OrderLine;

import java.sql.SQLException;

public class DBOrderLine{

	public DBOrderLine() {
		
	}
	
	public OrderLine addOrderLine(OrderLine orderLine, int saleOrderId) throws SQLException {
		String sql = String.format("insert into OrderLine (saleOrderId, quantity, productId) values (%d, %d, %d)",saleOrderId, orderLine.getQuantity(), orderLine.getProduct().getId());
		int id = DBConnection.getInstance().executeUpdate(sql);
		orderLine.setId(id);
		return orderLine;
	}

	
	public ResultSet findOrderLineBySaleOrderId(int saleOrderId) throws SQLException {
		ResultSet rs = null;
		String sql = String.format("select * from OrderLine where saleOrderId = %d",saleOrderId);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			rs = s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return rs;
	}
	
}
