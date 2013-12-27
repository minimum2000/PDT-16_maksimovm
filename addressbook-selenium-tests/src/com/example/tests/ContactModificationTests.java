package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		ContactData contact = new ContactData();
		contact.firstName = "Test";
		contact.lastName = "Test Test";
		app.getContactHelper().fillNewContact(contact);
		app.getContactHelper().updateContact(1);
		app.getNavigationHelper().returnHomePage();
	}

}
