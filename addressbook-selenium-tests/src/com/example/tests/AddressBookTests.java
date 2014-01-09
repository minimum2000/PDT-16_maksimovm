package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class AddressBookTests extends TestBase {

  
  
  @Test(dataProvider = "randomValidContactGenerator")
  public void testAddressBookWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().initNewAdressBookCreation();
    app.getContactHelper().fillNewContact(contact, true);
    app.getContactHelper().submitNewContactCreation();
    app.getNavigationHelper().returnHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
