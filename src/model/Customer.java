package model;

public class Customer {
	
	//fields for class Customer
	private String fName;
	private String lName;
	private String phoneNo;
	private String email;
	private String address;
	private String zipcode;
	private String city;
	private CustomerType type;
	private int id;
	
	public Customer(String fName, String lName, String address, String phoneNo, String email, String zipcode, String city, CustomerType type) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.zipcode = zipcode;
		this.city = city;
		this.type = type;
	}

	
	public CustomerType getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
