package graphics;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CtrlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CtrlPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton btnNewButton_1 = new JButton("Start Race");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(51, 517, 150, 33);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show info");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(51, 556, 150, 33);
		add(btnNewButton_2);

	}

}
