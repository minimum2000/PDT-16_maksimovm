package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitNewContactCreation() {
		click(By.name("submit"));
	}

	public void fillNewContact(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homePhone);
		type(By.name("mobile"), contact.mobilePhone);
		type(By.name("work"), contact.workPhone);
		type(By.name("email"), contact.firstEmail);
		type(By.name("email2"), contact.secondaryEmail);
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    selectByText(By.name("new_group"), contact.groupSelect);
	    type(By.name("address2"), contact.secondaryAddress);
	    type(By.name("phone2"), contact.homeField);
	}

	public void initNewAdressBookCreation() {
		click(By.linkText("add new"));
	}

}
