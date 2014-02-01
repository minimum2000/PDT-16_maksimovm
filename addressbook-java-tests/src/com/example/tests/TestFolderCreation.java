package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import com.example.fw.Folders;

public class TestFolderCreation extends TestBase {

	@Test
	public void testFolderCreation() {
		String folder = "newfolder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}
	
	@Test
	public void testVariousFoldersCreation() {
		String folder1 = "newfolder1";
		String folder2 = "newfolder2";
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1), is(not(nullValue())));
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
		app.getFolderHelper().createFolder(folder2);
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders.withAdded(folder2)));		
	}
	
	@Test
	public void testFoldersWithSameNameCreation() {
		String folder = "newfolder3";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
		app.getFolderHelper().createFolder(folder);
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders));		
	}
}
