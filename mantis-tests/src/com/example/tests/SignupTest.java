package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.AccountHelper;
import com.example.fw.Admin;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignupTest extends TestBase {

	public User user = new User().setLogin("testuser1")
			  .setPassword("123456")
			  .setEmail("testuser1@localhost.localdomain");
	
	private JamesHelper james;
	private AccountHelper accHelper;
	
	@BeforeClass
	public void createMailUser() {
		james = app.getJamesHelper();
		accHelper = app.getAccountHelper();
		if (! james.doesUserExist(user.login)) {
			james.createUser(user.login, user.password);
		}
	}
	
	@AfterClass
	public void deleteUser() {
		if (james.doesUserExist(user.login)) {
			james.deleteUser(user.login);
		}
	}
	
	//@Test
	public void newUserShouldSignUp() {
		accHelper.signup(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(), equalTo(user.login));
	}
	
	//@Test
	public void existingUserShouldNotSignUp() {
		try {
			accHelper.signup(user);
		} catch (Exception e) {
			assertThat(e.getMessage(), containsString("That username is already being used"));
			return;
		}
		fail("Exception expected");
	}
	
	private Admin admin = new Admin().setLogin("administrator")
									 .setPassword("root");
	
	@Test
	public void deleteCreatedUser() {
		accHelper.signupAdmin(admin);
		accHelper.deleteUserByAdmin();
	}
}
