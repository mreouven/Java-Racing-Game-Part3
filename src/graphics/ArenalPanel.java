package graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ArenalPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private final static String[] arenaList = { "Land Arena", "Naval Arena", "Aeral Arena"};
	private static final long serialVersionUID = 1L;
	
	
	private JTextField textField;


	/**
	 * Create the panel.
	 */
	public ArenalPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(187,126);
		
		
		JLabel lblChooseArena = new JLabel("Choose Arena:");
		lblChooseArena.setFont(new Font("Tahoma", Font.PLAIN, 16 ));
		lblChooseArena.setBounds(64, 0, 112, 25);
		
		add(lblChooseArena);
		add(Box.createGlue()); 
		
		JComboBox<?> comboBox = new JComboBox(arenaList);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(63, 28, 113, 25);
		comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(comboBox);
		add(Box.createGlue()); 
		
		JLabel lblArenaLenght = new JLabel("Arena Lenght:");
		lblArenaLenght.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArenaLenght.setBounds(63, 53, 112, 25);
		add(lblArenaLenght);
		add(Box.createGlue()); 
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(63, 74, 113, 33);
		add(textField);
		textField.setColumns(10);
		add(Box.createGlue()); 
		JButton btnNewButton = new JButton("Build Arena");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(51, 160, 150, 33);
		btnNewButton.addActionListener(this);
		add(btnNewButton);
		add(Box.createGlue()); 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
