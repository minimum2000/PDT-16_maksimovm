package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
  
  @DataProvider
  	public Iterator<Object[]> contactsFromFile() throws IOException {
  		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
  	}

@Test(dataProvider = "contactsFromFile")
  public void testAddressBookWithValidData(ContactData contact) throws Exception {
    // save old state
	SortedListOf<ContactData> oldList = app.getModel().getContacts();
   
    // actions
    app.getContactHelper().createContact(contact);

    // save new state
    SortedListOf<ContactData> newList = app.getModel().getContacts();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
    // compare model to Implementation
    if (wantToCheck()) {
    	if ("yes".equals(app.getProperty("check.db"))) {
    	
    		assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
    	}	
    	if ("yes".equals(app.getProperty("check.ui"))) {
    		assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
    	}
    }
  }
}
