package com.example.tests;

import org.testng.annotations.Test;

public class AddressBookTests extends TestBase {

  @Test
  public void testNotEmptyAddressBook() throws Exception {
    app.navigationHelper.openMainPage();
    app.contatHelper.initNewAdressBookCreation();
    ContactData contact = new ContactData();
    contact.f_name = "first name 1";
    contact.l_name = "last name 1";
    contact.address = "address 1";
    contact.dd_birth = "10";
    contact.f_email = "first e-mail";
    contact.group_select = "group name 1";
    contact.home_field = "home field";
    contact.home_phone = "home phone 1";
    contact.mm_birth = "July";
    contact.mob_phone = "mobile telephone 1";
    contact.s_email = "secondary e-mail";
    contact.sec_address = "secondary address 1";
    contact.wrk_phone = "work telephone";
    contact.yyyy_birth = "1845";
	app.contatHelper.fillNewContact(app, this, contact);
    app.contatHelper.submitNewContactCreation();
    app.navigationHelper.returnHomePage();
  }
  
  @Test
  public void testEmptyAddressBook() throws Exception {
    app.navigationHelper.openMainPage();
    app.contatHelper.initNewAdressBookCreation();
    app.contatHelper.fillNewContact(app, this, new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
    app.contatHelper.submitNewContactCreation();
    app.navigationHelper.returnHomePage();
  }
}
