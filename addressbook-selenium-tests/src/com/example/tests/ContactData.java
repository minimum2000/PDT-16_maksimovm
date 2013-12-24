package com.example.tests;

public class ContactData {
	
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String firstEmail;
	public String secondaryEmail;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String groupSelect;
	public String secondaryAddress;
	public String homeField;

	public ContactData() {
	}
	
	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String firstEmail, String secondaryEmail, String birthDay, String birthMonth,
			String birthYear, String groupSelect, String secondaryAddress,
			String homeField) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.firstEmail = firstEmail;
		this.secondaryEmail = secondaryEmail;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.groupSelect = groupSelect;
		this.secondaryAddress = secondaryAddress;
		this.homeField = homeField;
	}
}