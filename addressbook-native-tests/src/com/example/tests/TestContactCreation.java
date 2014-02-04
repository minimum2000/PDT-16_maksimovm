package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	@Test
	public void shouldCreateContactWithValidData() {
		Contact contact = new Contact().setFirstName("tester").setLastName("tester");
		app.getContactHelper().createContact(contact);
	}

}
