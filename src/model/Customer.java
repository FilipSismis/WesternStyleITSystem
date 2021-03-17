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
	
	public Customer(String fName, String lName, String address, String phoneNo, String email, String zipcode, String city) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.zipcode = zipcode;
		this.city = city;
		type = CustomerType.PERSON;
	}

	public Customer(String fName, String address, String phoneNo, String email, String zipcode, String city) {
		super();
		this.fName = fName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.zipcode = zipcode;
		this.city = city;
		type = CustomerType.CLUB;
	}
	
	public CustomerType getType() {
		return type;
	}
	
	
}
