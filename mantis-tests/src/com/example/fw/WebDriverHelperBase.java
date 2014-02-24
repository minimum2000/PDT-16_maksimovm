package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriverHelperBase extends HelperBase {
	
	protected WebDriver driver;
	public boolean acceptNextAlert = true;

	public WebDriverHelperBase(ApplicationManager manager){
		super(manager);
		this.driver = manager.getDriver();
	}
	
	public boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    try {
	      return driver.findElements(by).size() > 0;
	    } finally {
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	    	driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    acceptNextAlert = true;
	    }
	  }

	protected void type(By locator, String text) {
		if (text != null){
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		}
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null){
		new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}
	
	protected void openUrl(String string) {
		driver.get(manager.getProperty("baseUrl") + string);
	}
}
