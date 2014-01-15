package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
		app.getContactHelper()
			.editContact(index)
			.fillNewContact(contact, MODIFICATION)
			.updateContact(1); 
		app.getNavigationHelper().returnHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void anotherContactModification(ContactData contact){
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();

	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    
	    // actions
		app.getContactHelper().editContactAnotherModification(index);
		app.getContactHelper().fillNewContact(contact, MODIFICATION);
		app.getContactHelper().updateContact(1);
		app.getNavigationHelper().returnHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
