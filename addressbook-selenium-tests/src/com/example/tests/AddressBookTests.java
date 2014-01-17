package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;

public class AddressBookTests extends TestBase {

  
  
  @Test(dataProvider = "randomValidContactGenerator")
  public void testAddressBookWithValidData(ContactData contact) throws Exception {
    app.navigateTo().mainPage();
    
    // save old state
    ContactHelper contactHelper = app.getContactHelper();
	List<ContactData> oldList = contactHelper.getContacts();
    
    // actions
    app.getContactHelper()
    	.initNewAdressBookCreation()
    	.fillNewContact(contact, CREATION)
    	.submitNewContactCreation();
    app.navigateTo().homePage();
    
    // save new state
    List<ContactData> newList = contactHelper.getContacts();
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
