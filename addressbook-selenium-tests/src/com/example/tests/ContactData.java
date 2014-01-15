package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String firstEmail;
	private String secondaryEmail;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String groupSelect;
	private String secondaryAddress;
	private String homeField;

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
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", mobilePhone=" + mobilePhone + ", firstEmail=" + firstEmail 
				+ ", birthDay=" + birthDay + ", birthMonth="
				+ birthMonth + ", birthYear=" + birthYear + ", groupSelect="
				+ groupSelect + "]";
	}

	@Override
	public int hashCode() {
		int result = 1;
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
		   int lastnameResult = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		   if (lastnameResult != 0) {
		     return lastnameResult;
		   }
		   return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}

	public ContactData withFirstEmail(String firstEmail) {
		this.firstEmail = firstEmail;
		return this;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withGroupSelect(String groupSelect) {
		this.groupSelect = groupSelect;
		return this;
	}

	public ContactData withHomeField(String homeField) {
		this.homeField = homeField;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
		return this;
	}

	public ContactData withSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getFirstEmail() {
		return firstEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getGroupSelect() {
		return groupSelect;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getHomeField() {
		return homeField;
	}
	
}