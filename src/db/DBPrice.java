package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import model.Price;
import model.PriceType;

public class DBPrice {
	
	public DBPrice() {	
	
	}
	
	public List<Price> findPriceByProductId(int productId)throws SQLException{
		List<Price> priceList = new ArrayList();
		//need to add date to the SQL query 
		String sql = String.format("select price, priceType from Price where productId = %d",productId);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			priceList = buildPriceList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return priceList;
	}
	
	private Price buildPrice(ResultSet rs)throws SQLException {
		Price price = null;
		PriceType pt = PriceType.valueOf(rs.getString("priceType"));
		price = new Price(rs.getDouble("price"), pt);
		return price;
	}
	
	private List<Price> buildPriceList(ResultSet rs)throws SQLException{
		ArrayList<Price> priceList = new ArrayList();
		while(rs.next()) {
			Price price = buildPrice(rs);
			priceList.add(price);
		}
		return priceList;
	}
}
