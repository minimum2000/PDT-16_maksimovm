package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper submitNewContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper fillNewContact(ContactData contact, boolean param) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homePhone);
		type(By.name("mobile"), contact.mobilePhone);
		type(By.name("work"), contact.workPhone);
		type(By.name("email"), contact.firstEmail);
		type(By.name("email2"), contact.secondaryEmail);
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    if (param) {
	    selectByText(By.name("new_group"), contact.groupSelect);
	    }
	    type(By.name("address2"), contact.secondaryAddress);
	    type(By.name("phone2"), contact.homeField);
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
			
			ContactData contact = new ContactData();
			
			contact.firstName = firstName;
			contact.lastName = lastName;
			contacts.add(contact);
		}
		return contacts;
	}

}
