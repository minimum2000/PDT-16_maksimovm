package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AddressBookTests extends TestBase {
  
  @Test(dataProvider = "randomValidContactGenerator")
  public void testAddressBookWithValidData(ContactData contact) throws Exception {
    // save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().createContact(contact);

    // save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
}
