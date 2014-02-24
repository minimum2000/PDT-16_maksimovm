package com.example.fw;

import org.openqa.selenium.By;

public class AccountHelper extends WebDriverHelperBase {

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user) {
		openUrl("/");
		click(By.cssSelector("span.bracket-link"));
	    type(By.name("username"), user.login);
	    type(By.name("email"), user.email);
	    click(By.cssSelector("input.button"));
	    
	}

	public boolean isLogged(User user) {
		return false;
	}

}
