package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();

		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
		app.getContactHelper().deleteContact(0,2);
		app.getNavigationHelper().returnHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void anotherDeleteSomeContact() {
		app.getNavigationHelper().openMainPage();

		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
		app.getContactHelper().anotherDeleteContact(0,2);
		app.getNavigationHelper().returnHomePage();		
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
