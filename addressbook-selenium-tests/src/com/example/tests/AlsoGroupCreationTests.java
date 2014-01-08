package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class AlsoGroupCreationTests extends TestBase {

	 @Test(dataProvider = "randomValidGroupGenerator")
	  public void testGroupCreationWithValidData(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
	   
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
	}
