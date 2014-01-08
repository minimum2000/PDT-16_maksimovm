package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddressBookTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> randomValidContactGenerator() {
	  List<Object[]> list = new ArrayList<Object[]>();
	  for (int i = 0; i < 2; i++){
		  ContactData contact = new ContactData();
		  contact.address = generateRandomString();
		  contact.birthDay = generateRandomBirthDay();
		  contact.birthMonth = generateRandomBirthMonth();
		  contact.birthYear = generateRandomString();
		  contact.firstEmail = generateRandomString();
		  contact.firstName = generateRandomString();
		  contact.groupSelect = generateRandomGroupSelect();
		  contact.homeField = generateRandomString();
		  contact.homePhone = generateRandomString();
		  contact.lastName = generateRandomString();
		  contact.mobilePhone = generateRandomString();
		  contact.secondaryAddress = generateRandomString();
		  contact.secondaryEmail = generateRandomString();
		  contact.workPhone = generateRandomString();
		  list.add(new Object[]{contact});
	  }
	  return list.iterator();
  }

  public String generateRandomString() {
	  Random rnd = new Random();
	  if (rnd.nextInt(3) == 0) {
		 return "";
	  } else {
	  return "test" + rnd.nextInt();
	  }
  }
  
  public String generateRandomBirthDay() {
	  Random rnd = new Random();
	  if (rnd.nextInt(3) == 0) {
		  return "-";
	  } else {
		  return Integer.toString(rnd.nextInt(31-0) + 0);
	  }
  }
  
  public String generateRandomBirthMonth() {
	  String[] month = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
	  Random rnd = new Random();
	  if (rnd.nextInt() == 0) {
		  return "-";
	  } else {
		  return month[rnd.nextInt(month.length)];
	  }
  }
  
  public String generateRandomGroupSelect() {
	  List<GroupData> groups = app.getGroupHelper().getGroups();
	  int listSize = groups.size();
	  Random rnd = new Random();
	  if (rnd.nextInt() == 0) {
		  return "[none]";
	  } else {
		  int randomIndex = rnd.nextInt(listSize);
		  GroupData randomGroup = groups.get(randomIndex);
		  return randomGroup.name;
	  }
  }
  
  @Test(dataProvider = "randomValidContactGenerator")
  public void testAddressBookWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().initNewAdressBookCreation();
    app.getContactHelper().fillNewContact(contact);
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
