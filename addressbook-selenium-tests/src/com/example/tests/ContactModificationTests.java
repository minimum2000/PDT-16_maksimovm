package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContact(2,2);
		ContactData contact = new ContactData();
		contact.firstName = "Test1";
		contact.lastName = "Test1 Test1";
		app.getContactHelper().fillNewContact(contact);
		app.getContactHelper().updateContact(1);
		app.getNavigationHelper().returnHomePage();
	}
	
	@Test
	public void anotherContactModification(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContactAnotherModification(5,3);
		ContactData contact = new ContactData();
		contact.firstName = "Test first name secondary modification";
		contact.lastName = "Test last name secondary modification";
		contact.firstEmail = "Test first e-mail secondary modification";
		app.getContactHelper().fillNewContact(contact);
		app.getContactHelper().updateContact(1);
		app.getNavigationHelper().returnHomePage();
	}

}
