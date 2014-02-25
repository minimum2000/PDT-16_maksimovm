package com.example.tests;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.User;

public class SignupTest extends TestBase {

	public User user = new User().setLogin("testuser1")
			  .setPassword("123456")
			  .setEmail("testuser1@localhost.localdomain");
	
	@BeforeClass
	public void createMailUser() {
		app.getJamesHelper().createUser(user.login, user.password);
	}
	
	@AfterClass
	public void deleteUser() {
		app.getJamesHelper().deleteUser(user.login);
	}
	
	@Test
	public void newUserShouldSignUp() {
		
		app.getAccountHelper().signup(user);
		assertTrue(app.getAccountHelper().isLogged(user));
	}
	
}
