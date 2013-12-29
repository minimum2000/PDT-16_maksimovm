package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AddressBookTests extends TestBase {

  @Test
  public void testNotEmptyAddressBook() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().initNewAdressBookCreation();
    ContactData contact = new ContactData();
    contact.firstName = "first name 1";
    contact.lastName = "last name 1";
    contact.address = "address 1";
    contact.birthDay = "10";
    contact.firstEmail = "first e-mail";
    contact.groupSelect = "group name 1";
    contact.homeField = "home field";
    contact.homePhone = "home phone 1";
    contact.birthMonth = "July";
    contact.mobilePhone = "mobile telephone 1";
    contact.secondaryEmail = "secondary e-mail";
    contact.secondaryAddress = "secondary address 1";
    contact.workPhone = "work telephone";
    contact.birthYear = "1845";
	app.getContactHelper().fillNewContact(contact);
    app.getContactHelper().submitNewContactCreation();
    app.getNavigationHelper().returnHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertEquals(newList.size(), oldList.size()+1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
  //@Test
  public void testEmptyAddressBook() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initNewAdressBookCreation();
    app.getContactHelper().fillNewContact(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
    app.getContactHelper().submitNewContactCreation();
    app.getNavigationHelper().returnHomePage();
  }
}
