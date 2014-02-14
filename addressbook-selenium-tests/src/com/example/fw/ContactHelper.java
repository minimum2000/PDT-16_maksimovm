package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		} 
		return cachedContacts;
	}
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> tableRows = driver.findElements(By.name("entry"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String firstName = cells.get(2).getText();
			String lastName = cells.get(1).getText();
			cachedContacts.add(new ContactData()
									.withFirstName(firstName)
									.withLastName(lastName));
		}
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().groupsPage();
		initNewAdressBookCreation();
    	fillNewContact(contact, CREATION);
    	submitNewContactCreation();
    	manager.navigateTo().mainPage();
    	rebuildCache();
    	return this;
	}
	
	public ContactHelper deleteContact(int indexEdit, int deleteButton) {
		manager.navigateTo().mainPage();
		selectContactByIndex(indexEdit);
		editOrDeleteContact(deleteButton);
		manager.navigateTo().mainPage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper anotherDeleteContact(int detailButton, int indexDeleteOrUpdate) {
		manager.navigateTo().mainPage();
		contactDetail(detailButton);
		editOrDeleteContact(indexDeleteOrUpdate);
		manager.navigateTo().mainPage();
		rebuildCache();
		return this;
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		editContact(index);
		fillNewContact(contact, MODIFICATION);
		updateContact(1); 
		manager.navigateTo().mainPage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper anotherModifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		editContactAnotherModification(index);
		fillNewContact(contact, MODIFICATION);
		updateContact(1);
		manager.navigateTo().mainPage();
		rebuildCache();
		return this;
	}
	// ----------------------------------------------------------------

	public ContactHelper submitNewContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillNewContact(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHomePhone());
		type(By.name("mobile"), contact.getMobilePhone());
		type(By.name("work"), contact.getWorkPhone());
		type(By.name("email"), contact.getFirstEmail());
		type(By.name("email2"), contact.getSecondaryEmail());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    if (formType == CREATION) {
	    selectByText(By.name("new_group"), contact.getGroupSelect());
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() != 0){
	    		throw new Error ("Group selector exists in contact modification form");
	    	}
	    }
	    type(By.name("address2"), contact.getSecondaryAddress());
	    type(By.name("phone2"), contact.getHomeField());
	    return this;
	}

	public ContactHelper initNewAdressBookCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	private void selectContactByIndex(int indexEdit){
		click(By.xpath("(//img[@alt='Edit'])[" + (indexEdit+1) + "]"));
	}
	
	private void editOrDeleteContact(int indexDeleteOrUpdate) {
		click(By.xpath("(//input[@name='update'])[" + indexDeleteOrUpdate + "]"));
	}

	public ContactHelper updateContact(int updateButton) {
		editOrDeleteContact(updateButton);
		cachedContacts = null;
		return this;
	}

	private void contactDetail(int detailButton) {
		click(By.xpath("(//img[@alt='Details'])[" + (detailButton+1) + "]"));
		click(By.name("modifiy"));
	}
	
	public ContactHelper editContact(int detailButton) {
		contactDetail(detailButton);
		cachedContacts = null;
		return this;
	}

	public ContactHelper editContactAnotherModification(int indexEdit) {
		selectContactByIndex(indexEdit);
		cachedContacts = null;
		return this;
	}
}
