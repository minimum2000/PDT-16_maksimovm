package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private WebDriver driver;
	public String baseUrl;
	
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	
	
	public static ApplicationManager getInstance(){
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}

	public void stop() {
	    driver.quit();
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public void setProperties (Properties properties){
		this.properties = properties;
	}
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
	}

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null) {
			if ("firefox".equals(browser)){
				driver = new FirefoxDriver();    
			} else if ("ie".equals(browser)) {
				driver = new InternetExplorerDriver();
			} else {
				throw new Error("Unsupported browser:" + browser);
			}
			baseUrl = properties.getProperty("baseUrl");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		    }
		return driver;
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
		}
		return accountHelper;
	}
	
}
