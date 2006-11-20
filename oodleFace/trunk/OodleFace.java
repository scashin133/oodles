

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;


/*
 * Creator : Sam Archer
 */

public class OodleFace {

	// Changes
	// -ActionViz display their own results/ have execute button
	// -Wizards will also display their own results (launch() is no longer
	// nessesary
	
	

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
		Action manualQuery = new Action("Manual Query Entry", new QueryEntryPanel());
		Action tableEdit = new Action("Table Editor", new TableEditPanel());
		Action wizardQuery = new Action("Query Wizard", new QueryEntryWizardManager());
		Action wizardTable = new Action("Table Wizard", new TableModificationWizardManager());
		
		// Create Views and addActions to them
		View queryView = new View("Query", new ImageIcon("images/query.png"));
		queryView.addAction(manualQuery);
		queryView.addAction(wizardQuery);
		
		View tableView = new View("Table", new ImageIcon("images/table.png"));
		tableView.addAction(tableEdit);
		tableView.addAction(wizardTable);
		tableView.addAction(manualQuery);
		
		
		// Add views to ViewPanel (child of MainPanel)
		mainPanel.getChild().addView(queryView);
		mainPanel.getChild().addView(tableView);
		
		// Create and add SQL Execution Listener with new SQL
		// Executor
		mainPanel.getChild().getChild().getChild().addSQLExecutionListener(new SQLExecutionListener(new SQLExecutor()));
		
		// Vizibleize the main window.
		mainWindow.setVisible(true);

	}

}
