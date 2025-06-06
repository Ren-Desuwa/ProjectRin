package main;

import data_access_objects.DataAccessObjectManager;
import view.Main_Menu;

public class Launcher {
	public static void main(String[] args) {
		DataAccessObjectManager daoManager = DataAccessObjectManager.getInstance();
		Main_Menu.launch(daoManager);
	}
}
