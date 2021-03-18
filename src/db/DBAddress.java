package db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAddress {
	
	private String address;
	private String zip;
	private String city;
	private String country;
	
	public DBAddress() {
		
	}

	public String getAddress() {
		return address;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
	
	//first call this method which assigns values to the class variable than you can call 
	//getters of the variables to get the values out of DB  
	
	public void getFullAddressByAddresId(int addressId) throws SQLException {
		String sql = String.format("select * from AdressLines where id = %d",addressId);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			address = rs.getString("addressLine_1") + rs.getString("addressLine_2");
			getZipById(rs.getInt("zipcodeId"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void getZipById(int zipcodeId)throws SQLException{
		String sql = String.format("select * from ZipLocation where id = %d",zipcodeId);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			zip = "" + rs.getInt("zipcode");
			getCityById(rs.getInt("cityId"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void getCityById(int cityId)throws SQLException{
		String sql = String.format("select * from CityLocation where id = %d",cityId);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			city = rs.getString("city");
			country = rs.getString("country");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}	
	
}
