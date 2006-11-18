

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


/*
 * Creator : Sam Archer
 */

public class OodleFace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create and position main window
		JFrame mainWindow = new JFrame("OodleFACE");
		mainWindow.setBounds(200, 200, 640, 480);
		
		// Create menus
		JMenu fileMenu = new JMenu("File");
		
		// Create menuBar and add menus to it
		JMenuBar mainMenuBar = new JMenuBar();
		mainMenuBar.add(fileMenu);
		
		
		mainWindow.setJMenuBar(mainMenuBar);
		
		MainPanel mainPanel = new MainPanel();
		mainWindow.setContentPane(mainPanel);
		
		Action action1 = new Action("Click me 1", new QueryEntryPanel());
		Action action2 = new Action("Click me 2", new QueryEntryPanel());
		
		View tableView = new View("Table");
		tableView.addAction(action1);
		tableView.addAction(action2);
		
		View queryView = new View("Query");
		queryView.addAction(action2);
		queryView.addAction(action1);
		
		mainPanel.getChild().addView(tableView);
		mainPanel.getChild().addView(queryView);
		
		
		mainWindow.setVisible(true);

	}

}
