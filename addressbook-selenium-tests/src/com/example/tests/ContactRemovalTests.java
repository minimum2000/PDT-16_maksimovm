package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.navigateTo().mainPage();

		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
		app.getContactHelper().deleteContact(index,2);
		app.navigateTo().mainPage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void anotherDeleteSomeContact() {
		app.navigateTo().mainPage();

		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
		app.getContactHelper().anotherDeleteContact(0,2);
		app.navigateTo().mainPage();		
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
