package beggarHelp.model;

import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Alert {

	public static void alertSimple(String msg) {
		Toolkit.getDefaultToolkit().beep();
 	    JOptionPane optionPane = new JOptionPane(msg,JOptionPane.WARNING_MESSAGE);
 	    JDialog dialog = optionPane.createDialog("Warning!");
 	    dialog.setAlwaysOnTop(true);
 	    dialog.setVisible(true);
	}
}
