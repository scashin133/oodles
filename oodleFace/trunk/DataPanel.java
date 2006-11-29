import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

/*
 * Creator : Sam Archer
 * Nov 17, 2006
 */

public class DataPanel extends JPanel implements ActionListener{

	SQLExecutionListener executionListener;
	ActionVisualization actionVisualizationPanel;

	public DataPanel(){
		super();

		this.initialize();
	}

	public void addSQLExecutionListener(SQLExecutionListener sqlel){
		executionListener = sqlel;
	}

	private void initialize(){
		//Set Border
		this.setBorder(new EtchedBorder());
		//Set Layout
		this.setLayout(new BorderLayout());
	}

	//This is called by the ActionPanel when an action is selected.
	public void showActionContent(Action targetAction){
		//Remove any components in the DataPanel
		this.removeAll();
		//Add the Panel associated with the action
		actionVisualizationPanel = targetAction.getPanel();
		this.add((JPanel)actionVisualizationPanel, BorderLayout.CENTER);
		// TODO For whatever reason this needs to be revailidated AND
		// repainted every time it's changed in order to immediately
		// reflect action choices.  If anyone knows a way around this
		// feel free to change it.
		this.revalidate();
		this.repaint();

		// TODO I THINK/HOPE that old buttons will still get
		// garbage collected when they are removed from this
		// panel and don't have to be explicitly unActionListener'd
		actionVisualizationPanel.getExecuteButton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent a) {

		// If the execute button has been pressed, send the
		// result of the actionPanel to the ExecutionListener
		if (a.getActionCommand().equals("execute")){
			// If the execute button was pressed, give the executionResult
			// back to the Panel
			try {
				ArrayList<String> commands = new ArrayList<String>();
				commands = actionVisualizationPanel.getResult();
				String firstCommand = commands.get(0);
				String tableName = OodleFaceUtil.getTableName(firstCommand);
				if (tableName != null){
					actionVisualizationPanel.executionResult(executionListener.executeSQL(commands, tableName));
				}
				// If the was no table name found:
				else {
					DefaultTableModel errorModel = new DefaultTableModel(1,1);
					errorModel.setValueAt("No table name found", 0, 0);
					JTable errorTable = new JTable(errorModel);
					actionVisualizationPanel.executionResult(errorTable);
				}
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}

	}

}
