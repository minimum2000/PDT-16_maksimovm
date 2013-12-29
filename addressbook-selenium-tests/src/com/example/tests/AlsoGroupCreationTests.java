package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {

	@Test
	  public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
	    GroupData group = new GroupData();
	    group.name = "";
	    group.header = "";
	    group.footer = "";
		app.getGroupHelper().initNewGroupCreation();
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	    
	    // save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	  }
	  
	  @Test
	  public void testNonEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
	   
	    app.getGroupHelper().initNewGroupCreation();
	    GroupData group = new GroupData();
	    group.name = "aaa";
	    group.header = "header 1";
	    group.footer = "footer 1";
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	    
	    // save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	  }
}