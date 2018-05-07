package graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FinalPanel extends JPanel {
	
	
	public FinalPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		ArenaField field = new ArenaField();
		add(field,BorderLayout.EAST);
		ControlPane control = new ControlPane();
		add(control,BorderLayout.AFTER_LAST_LINE);

	}

}
