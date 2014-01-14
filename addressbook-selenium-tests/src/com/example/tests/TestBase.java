package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	
	@DataProvider
	  public Iterator<Object[]> randomValidGroupGenerator() {
			List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 5; i++){
				GroupData group = new GroupData()
					.withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
				group.name = generateRandomString();
				group.header = generateRandomString();
				group.footer = generateRandomString();
				list.add(new Object[]{group});
			}
			return list.iterator();
		}

	@DataProvider
	  public Iterator<Object[]> randomValidContactGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++){
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
			  return Integer.toString(rnd.nextInt(31) + 1);
		  }
	  }
	  
	  public String generateRandomBirthMonth() {
		  String[] month = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "-";
		  } else {
			  return month[rnd.nextInt(month.length)];
		  }
	  }
	  
	  public String generateRandomGroupSelect() {
		  app.getGroupHelper().gotoGroupsPage();
		  List<GroupData> groups = app.getGroupHelper().getGroups();
		  int listSize = groups.size();
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "[none]";
		  } else {
			  int randomIndex = rnd.nextInt(listSize);
			  GroupData randomGroup = groups.get(randomIndex);
			  return randomGroup.name;
		  }
	  }
}
