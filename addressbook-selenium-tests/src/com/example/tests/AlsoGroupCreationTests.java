package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.gotoGroupsPage();
    app.initNewGroupCreation();
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }
  
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.gotoGroupsPage();
    app.initNewGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.fillGroupForm(this, group);
    app.submitGroupCreation();
    app.returnToGroupPage();
  }
}