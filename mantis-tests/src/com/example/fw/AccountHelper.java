package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase {

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user) {
		openUrl("/");
		click(By.linkText("Signup for a new account"));
	    type(By.name("username"), user.login);
	    type(By.name("email"), user.email);
	    click(By.cssSelector("input.button"));
	    
	    WebElement errorMessage = findElement(By.cssSelector("table.width50 tbody tr td p"));
	    if (errorMessage != null) {
	    	throw new RuntimeException(errorMessage.getText());
	    }
	    
	    pause(5000);
	    String msg = null;
	    for (int i = 0; i < 10; i++) {
	      msg = manager.getMailHelper().getNewMail(user.login, user.password);
	      if (msg != null) {
	        break; // прервать цикл
	      }
	      pause(5000);
	    }
	    
	    String confirmationLink = getConfirmationLink(msg);
	    openAbsoluteUrl(confirmationLink);
	    
	    type(By.name("password"), user.password);
	    type(By.name("password_confirm"), user.password);
	    click(By.cssSelector("input.button"));
	}

	public String getConfirmationLink(String text) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}

	public void login(User user) {
		openUrl("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
	}

	public String loggedUser() {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}
}
