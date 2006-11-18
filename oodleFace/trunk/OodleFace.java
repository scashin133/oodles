

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;


/*
 * Creator : Sam Archer
 */

public class OodleFace {


	// I basically copied this out of the tutorial, something about
	// thread safe.  I don't entirely understand it, but it works fine.
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeGUI();
            }
        });
	}
	protected static void initializeGUI(){	
		// Create and position main window
		JFrame mainWindow = new JFrame("OodleFACE");
		mainWindow.setBounds(200, 200, 640, 480);
		
		// Create menus
		JMenu fileMenu = new JMenu("File");
		
		// Create menuBar and add menus to it
		JMenuBar mainMenuBar = new JMenuBar();
		mainMenuBar.add(fileMenu);
		
		// Set menu bar
		mainWindow.setJMenuBar(mainMenuBar);
		
		// TODO Should this be declared in a variable outside
		// of the initialize method?
		MainPanel mainPanel = new MainPanel();
		mainWindow.setContentPane(mainPanel);
		
		// Create actions
		Action action1 = new Action("Query Entry", new QueryEntryPanel());
		Action action2 = new Action("Table Editor", new TableEditPanel());
		
		// Create Views and addActions to them
		View tableView = new View("Table", new ImageIcon("images/table.png"));
		tableView.addAction(action1);
		tableView.addAction(action2);
		
		View queryView = new View("Query", new ImageIcon("images/table.png"));
		queryView.addAction(action2);
		queryView.addAction(action1);
		
		// Add views to ViewPanel (child of MainPanel)
		mainPanel.getChild().addView(tableView);
		mainPanel.getChild().addView(queryView);
		
		// Vizibleize the main window.
		mainWindow.setVisible(true);

	}

}
