package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper submitNewContactCreation() {
		click(By.name("submit"));
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

	public ContactHelper deleteContact(int indexEdit, int deleteButton) {
		selectContactByIndex(indexEdit);
		editOrDeleteContact(deleteButton);
		return this;
	}

	public ContactHelper updateContact(int updateButton) {
		editOrDeleteContact(updateButton);
		return this;
	}

	private void contactDetail(int detailButton) {
		click(By.xpath("(//img[@alt='Details'])[" + (detailButton+1) + "]"));
		click(By.name("modifiy"));
	}
	
	public ContactHelper editContact(int detailButton) {
		contactDetail(detailButton);
		return this;
	}

	public ContactHelper editContactAnotherModification(int indexEdit) {
		selectContactByIndex(indexEdit);
		return this;
	}

	public ContactHelper anotherDeleteContact(int detailButton, int indexDeleteOrUpdate) {
		contactDetail(detailButton);
		editOrDeleteContact(indexDeleteOrUpdate);
		return this;
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> tableRows = driver.findElements(By.name("entry"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String firstName = cells.get(2).getText();
			String lastName = cells.get(1).getText();
			contacts.add(new ContactData()
									.withFirstName(firstName)
									.withLastName(lastName));
		}
		return contacts;
	}

}
