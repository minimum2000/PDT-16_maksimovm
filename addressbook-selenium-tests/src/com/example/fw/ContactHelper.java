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

	public void submitNewContactCreation() {
		click(By.name("submit"));
	}

	public void fillNewContact(ContactData contact) {
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
	    selectByText(By.name("new_group"), contact.groupSelect);
	    type(By.name("address2"), contact.secondaryAddress);
	    type(By.name("phone2"), contact.homeField);
	}

	public void initNewAdressBookCreation() {
		click(By.linkText("add new"));
	}
	
	private void selectContactByIndex(int indexEdit, int indexCheckbox){
		click(By.xpath("(//input[@id='id" + indexCheckbox + "'])"));
		click(By.xpath("(//img[@alt='Edit'])[" + indexEdit + "]"));
	}
	
	private void editOrDeleteContact(int indexDeleteOrUpdate) {
		click(By.xpath("(//input[@name='update'])[" + indexDeleteOrUpdate + "]"));
	}

	public void deleteContact(int indexEdit, int indexCheckbox, int deleteButton) {
		selectContactByIndex(indexEdit, indexCheckbox);
		editOrDeleteContact(deleteButton);
	}

	public void updateContact(int updateButton) {
		editOrDeleteContact(updateButton);
	}

	private void contactDetail(int indexCheckbox , int detailButton) {
		click(By.xpath("(//input[@id='id" + indexCheckbox + "'])"));
		click(By.xpath("(//img[@alt='Details'])[" + detailButton + "]"));
		click(By.name("modifiy"));
	}
	
	public void editContact(int indexCheckbox, int detailButton) {
		contactDetail(indexCheckbox, detailButton);
	}

	public void editContactAnotherModification(int indexEdit, int indexCheckbox) {
		selectContactByIndex(indexEdit, indexCheckbox);
	}

	public void anotherDeleteContact(int indexCheckbox, int detailButton, int indexDeleteOrUpdate) {
		contactDetail(indexCheckbox, detailButton);
		editOrDeleteContact(indexDeleteOrUpdate);
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			contact.firstName = title.substring("Select (".length(), title.length() - " last name 1)".length());
			contacts.add(contact);
		}
		return contacts;
	}

}
