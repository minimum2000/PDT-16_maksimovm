package com.example.tests;

public class GroupData {
	// to save in commit
	public String name;
	public String header;
	public String footer;

	public GroupData() {		
	}
	
	public GroupData(String groupname, String header, String footer) {
		this.name = groupname;
		this.header = header;
		this.footer = footer;
	}
}