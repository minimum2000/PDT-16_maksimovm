package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
		app.getContactHelper().editContact(0);
		ContactData contact = new ContactData();
		contact.firstName = "Test1";
		contact.lastName = "Test1 Test1";
		app.getContactHelper().fillNewContact(contact);
		app.getContactHelper().updateContact(1);
		app.getNavigationHelper().returnHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void anotherContactModification(){
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
		app.getContactHelper().editContactAnotherModification(0);
		ContactData contact = new ContactData();
		contact.firstName = "Test first name secondary modification";
		contact.lastName = "Test last name secondary modification";
		contact.firstEmail = "Test first e-mail secondary modification";
		app.getContactHelper().fillNewContact(contact);
		app.getContactHelper().updateContact(1);
		app.getNavigationHelper().returnHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
