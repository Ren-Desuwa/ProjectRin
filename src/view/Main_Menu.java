package view;

import java.awt.EventQueue;
import javax.swing.JWindow;
import data_access_objects.DataAccessObjectManager;


public class Main_Menu extends JWindow {

	private static final long serialVersionUID = 1L;
	private DataAccessObjectManager daoManager;
	
	public static void launch(DataAccessObjectManager daoManager) {
		EventQueue.invokeLater(() -> {
			new Main_Menu(daoManager);
		});
	}
	
	private Main_Menu(DataAccessObjectManager daoManager) {
		this.daoManager = daoManager; 
		initComponents();
		setVisible(true);
	}

	private void initComponents() {

	}
}
