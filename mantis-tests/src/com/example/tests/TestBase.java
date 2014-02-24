package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
		app = ApplicationManager.getInstance();
		app.setProperties(properties);
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
	
	private void initAppplicationManager() throws Exception {
		   if (app == null) {
		        String configFile = System.getProperty("configFile", "Firefox.properties");
		        Properties properties = new Properties();
		        properties.load(new FileReader(new File(configFile)));
		        app = ApplicationManager.getInstance();
				app.setProperties(properties);
				checkCounter = 0;
		        checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
		   }
		 }
}
