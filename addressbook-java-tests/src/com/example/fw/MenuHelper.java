package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

public class MenuHelper extends HelpersBase {

	public MenuHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void pushCreateFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|New Folder...");
	}

	public void pushDeleteFolder(int index) {
		JTreeOperator folder = new JTreeOperator(mainFrame);
		folder.selectRow(index);
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|Delete");
	}

}
