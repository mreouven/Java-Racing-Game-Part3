package graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilities.EnumContainer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ControlPane extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> arenaChoice;
	private ArenaFrame frame;
	private final static String[] arenaList = { "Land Arena", "Naval Arena", "Aeral Arena"};
	private final static String[] colorList = {"RED", "GREEN", "BLUE", "BLACK", "YELLOW"};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public ControlPane(ArenaFrame f) {
		
		setFrame(f);
		setBackground(new Color(255, 228, 196));
		setLayout(null);
		
		JComboBox comboBox = new JComboBox(arenaList);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(63, 28, 113, 25);
		add(comboBox);
		
		JLabel lblChooseArena = new JLabel("Choose Arena:");
		lblChooseArena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseArena.setBounds(64, 0, 112, 25);
		add(lblChooseArena);
		
		JLabel lblArenaLenght = new JLabel("Arena Lenght:");
		lblArenaLenght.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArenaLenght.setBounds(63, 53, 112, 25);
		add(lblArenaLenght);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(63, 74, 113, 33);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblMaxBuildRacer = new JLabel("Max build racer:");
		lblMaxBuildRacer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaxBuildRacer.setBounds(63, 99, 122, 33);
		add(lblMaxBuildRacer);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(63, 121, 113, 33);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Build Arena");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(51, 160, 150, 33);
		btnNewButton.addActionListener(this);
		add(btnNewButton);
		
		JLabel lblChooseRacer = new JLabel("Choose Racer: ");
		lblChooseRacer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseRacer.setBounds(51, 203, 144, 33);
		add(lblChooseRacer);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(61, 232, 122, 25);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Choose color:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(51, 255, 115, 33);
		add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox(colorList);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(63, 278, 122, 25);
		add(comboBox_2);
		
		JLabel lblRacerName = new JLabel("Racer name:");
		lblRacerName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRacerName.setBounds(51, 297, 115, 33);
		add(lblRacerName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(63, 321, 113, 33);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(63, 370, 113, 33);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMaxSpeed = new JLabel("Max Speed:");
		lblMaxSpeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaxSpeed.setBounds(51, 347, 115, 33);
		add(lblMaxSpeed);
		
		JLabel lblAcceleration = new JLabel("Acceleration:");
		lblAcceleration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAcceleration.setBounds(51, 403, 115, 25);
		add(lblAcceleration);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 422, 113, 33);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddRacer = new JButton("Add Racer");
		btnAddRacer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddRacer.setBounds(51, 456, 150, 33);
		add(btnAddRacer);
		
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

	private void setFrame(ArenaFrame f) {
		frame=f;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!textField.getText().equals(""))
			{
			textField.setBackground(Color.WHITE);
			try {
				Integer.parseInt(textField.getText());
			} catch (NumberFormatException e1){
				textField.setText("NUMBER");
				textField.setBackground(Color.ORANGE);
			}
		}
		else {
			textField.setBackground(Color.RED);
			textField.setText("obligatoire");
			System.out.println("vide");
		}
		
		
		
	}
}
