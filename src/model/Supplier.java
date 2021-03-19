package model;

public class Supplier {
	
	private String name;;
	private String phoneNo;
	private String email;
	private String address;
	private String zipcode;
	private String city;
	private String country;
	private int id;
	
	public Supplier(String name, String phoneNo, String email, String address, String zipcode, String city, String country) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
