package graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.BorderLayout;


public class FinalPanel extends JPanel {
	
	public ArenaField field;
	public ControlPane control;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinalPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		field = new ArenaField();
		add(field,BorderLayout.EAST);
		control = new ControlPane();
		add(control,BorderLayout.AFTER_LAST_LINE);

	}
	public ControlPane getcontrol() {
		return control;
	}

}
