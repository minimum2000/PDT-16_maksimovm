package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}
	
	private void rebuildCache() {
		SortedListOf<GroupData> cachedGroups = new SortedListOf<GroupData>(); 
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withName(name));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initNewGroupCreation();
	    fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupPage();
	    rebuildCache();
	    return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		rebuildCache();
	return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupPage();
		rebuildCache();
		return this;
	}
	
	// ---------------------------------------------------------------------

	public GroupHelper returnToGroupPage() {
	    driver.findElement(By.linkText("group page")).click();
	    return this;
	}

	public GroupHelper submitGroupCreation() {
	    click(By.name("submit"));
	    cachedGroups = null;
	    return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
	    return this;
	  }

	public GroupHelper initNewGroupCreation() {
		click(By.name("new"));
	    return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ (index+1) + "]"));
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}
	
	public void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
}
