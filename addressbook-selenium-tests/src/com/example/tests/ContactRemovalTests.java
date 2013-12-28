package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
	// change parameters before launch
		app.getContactHelper().deleteContact(5,8,2);
		app.getNavigationHelper().returnHomePage();
	}

}
