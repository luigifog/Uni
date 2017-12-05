package uo.mp.uml.model;

public class Customer {

	private String idNumber;
	private String name;
	private String surname;
	private String phone;
	private String email;
	
	public Customer(String idNumber, String name, String surname) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNumber() {
		return idNumber;
	}

}
