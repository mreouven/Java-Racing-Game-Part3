package graphics;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RacerPanel extends JPanel {

	/**
	 * 
	 */
	
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static final long serialVersionUID = 1L;
	private final static String[] colorList = {"RED", "GREEN", "BLUE", "BLACK", "YELLOW"};
	/**
	 * Create the panel.
	 */
	public RacerPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblChooseRacer = new JLabel("Choose Racer: ");
		lblChooseRacer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseRacer.setBounds(51, 203, 144, 33);
		lblChooseRacer.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblChooseRacer);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(61, 232, 122, 25);
		comboBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Choose color:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(51, 255, 115, 33);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox(colorList);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(63, 278, 122, 25);
		comboBox_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(comboBox_2);
		
		JLabel lblRacerName = new JLabel("Racer name:");
		lblRacerName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRacerName.setBounds(51, 297, 115, 33);
		lblRacerName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblRacerName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(63, 321, 113, 33);
		textField_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMaxSpeed = new JLabel("Max Speed:");
		lblMaxSpeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaxSpeed.setBounds(51, 347, 115, 33);
		lblMaxSpeed.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblMaxSpeed);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(63, 370, 113, 33);
		textField_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(textField_3);
		textField_3.setColumns(10);
		
	
		
		JLabel lblAcceleration = new JLabel("Acceleration:");
		lblAcceleration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAcceleration.setBounds(51, 403, 115, 25);
		lblAcceleration.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAcceleration);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 422, 113, 33);
		textField_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(textField_4);
		textField_4.setColumns(10);
	}

}
