package com.example.fw;

public class Contact {

	public String firstname;
	public String lastname;

	public Contact setFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public Contact setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

}
