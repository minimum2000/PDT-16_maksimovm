package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	private int checkFrequency;
	private int checkCounter;

	@BeforeTest
	public void setUp() throws Exception {
		initAppplicationManager();
		String configFile = System.getProperty("configFile", "Firefox.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		checkCounter = 0;
		checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
	}
	
	protected boolean wantToCheck() {
		checkCounter++;
		if (checkCounter > checkFrequency) {
			checkCounter = 0;
			return true;
		} else {
			return false;
		}
			
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		initAppplicationManager();
		  app.stop();
	}
	
	@DataProvider
	  public Iterator<Object[]> randomValidGroupGenerator() {
		  try {
			initAppplicationManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
		}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	  public Iterator<Object[]> randomValidContactGenerator() {
		  try {
			initAppplicationManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return wrapContactsForDataProvider(generateRandomContacts(app, 5)).iterator();
	  }
	  
	  public static List<Object[]> wrapContactsForDataProvider(
			List<ContactData> contacts) {
		  List<Object[]> list = new ArrayList<Object[]>();
			for (ContactData contact : contacts) {
				list.add(new Object[]{contact});
			}
			return list;
	}
	  
	  private void initAppplicationManager() throws Exception {
		   if (app == null) {
		        String configFile = System.getProperty("configFile", "Firefox.properties");
		        Properties properties = new Properties();
		        properties.load(new FileReader(new File(configFile)));
		        app = new ApplicationManager(properties);
		        checkCounter = 0;
		        checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
		   }
		 }
}
