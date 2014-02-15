package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AddressBookTests extends TestBase {
  
  @DataProvider
  	public Iterator<Object[]> contactsFromFile() throws IOException {
  		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
  	}

@Test(dataProvider = "contactsFromFile")
  public void testAddressBookWithValidData(ContactData contact) throws Exception {
    // save old state
	SortedListOf<ContactData> oldList 
		= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
   
    // actions
    app.getContactHelper().createContact(contact);

    // save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
}
