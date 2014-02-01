package com.example.tests;

import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
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
	
}
