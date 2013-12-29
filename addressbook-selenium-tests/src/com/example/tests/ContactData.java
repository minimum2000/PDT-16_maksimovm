package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
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

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result
		//		+ ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		
		return this.firstName.compareTo(other.firstName);
	}
	
}