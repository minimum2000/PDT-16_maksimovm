package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class AlsoGroupCreationTests extends TestBase {

	 @Test(dataProvider = "randomValidGroupGenerator")
	  public void testGroupCreationWithValidData(GroupData group) throws Exception {
		// save old state
		    List<GroupData> oldList = app.getModel().getGroups();
		    
		    // actions
		    
		    app.getGroupHelper().createGroup(group);
		    
		    // save new state
		    List<GroupData> newList = app.getModel().getGroups();
		    
		    // compare states
		    oldList.add(group);
		    Collections.sort(oldList);
		    assertEquals(newList, oldList);
	  }
	}
