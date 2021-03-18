package db;

import model.SaleOrder;
import java.sql.SQLException;


public class DBSaleOrder{
	
	public DBSaleOrder() {
		
	}
	
	public SaleOrder addSaleOrder(SaleOrder saleOrder)throws SQLException {
		String sql = String.format("insert into SaleOrder (custmerId) values ('%d')", saleOrder.getCustomer().getId());
		int id = DBConnection.getInstance().executeUpdate(sql);
		saleOrder.setId(id);
		return saleOrder;
	}

}
