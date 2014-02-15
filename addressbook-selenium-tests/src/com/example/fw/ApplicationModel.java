package com.example.fw;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<GroupData> groups;
	
	public SortedListOf<GroupData> getGroups() {
		return groups;
	}
	
	public void setGroups(SortedListOf<GroupData> groups) {
		this.groups = new SortedListOf<GroupData>(groups);
	}
	
}
