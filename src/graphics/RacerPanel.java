package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilities.API;

public class RacerPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	
	private String name="";
	private double accel=-1;
	private double max_speed=-1;
	private static API api = API.getInstance();
	public ArenaField field;
	private JTextField nameRacer;
	private JTextField speedMax;
	private JTextField acceleration_field;
	JComboBox<String> comboBox_1;
	private static final long serialVersionUID = 1L;
	private final static String[] colorList = {"RED", "GREEN", "BLUE", "BLACK", "YELLOW"};
	/**
	 * Create the panel.
	 */
	public RacerPanel(JPanel field) {
		this.field=(ArenaField) field;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblChooseRacer = new JLabel("Choose Racer: ");
		lblChooseRacer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseRacer.setBounds(51, 203, 144, 33);
		lblChooseRacer.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblChooseRacer);
		
		comboBox_1 = new JComboBox<String>();
		api.setComboBox_1(comboBox_1);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(61, 232, 122, 25);
		comboBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Choose color:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(51, 255, 115, 33);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblNewLabel);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>(colorList);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(63, 278, 122, 25);
		comboBox_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(comboBox_2);
		
		JLabel lblRacerName = new JLabel("Racer name:");
		lblRacerName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRacerName.setBounds(51, 297, 115, 33);
		lblRacerName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblRacerName);
		
		nameRacer = new JTextField();
		nameRacer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameRacer.setBounds(63, 321, 113, 33);
		nameRacer.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(nameRacer);
		nameRacer.setColumns(10);
		
		JLabel lblMaxSpeed = new JLabel("Max Speed:");
		lblMaxSpeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaxSpeed.setBounds(51, 347, 115, 33);
		lblMaxSpeed.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblMaxSpeed);
		
		
		speedMax = new JTextField();
		speedMax.setBounds(63, 370, 113, 33);
		speedMax.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(speedMax);
		speedMax.setColumns(10);
		
	
		
		JLabel lblAcceleration = new JLabel("Acceleration:");
		lblAcceleration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAcceleration.setBounds(51, 403, 115, 25);
		lblAcceleration.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAcceleration);
		
		acceleration_field = new JTextField();
		acceleration_field.setBounds(63, 422, 113, 33);
		acceleration_field.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(acceleration_field);
		acceleration_field.setColumns(10);
		
		add(Box.createGlue()); 
		JButton btnNewButton = new JButton("Add racer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//btnNewButton.setBounds(51, 160, 150, 33);
		btnNewButton.addActionListener(this);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnNewButton);
		add(Box.createGlue()); 
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		;
		if(comboBox_1.getItemCount()<=0) {
			JOptionPane.showMessageDialog(this, "Build Arena first","ERROR",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		speedMax.setBackground(Color.WHITE);
		if (!nameRacer.getText().equals("")){nameRacer.setBackground(Color.WHITE);name=nameRacer.getText();}else {nameRacer.setBackground(Color.RED);JOptionPane.showMessageDialog(this, "Invalid Content please enter Information","EROOR",JOptionPane.ERROR_MESSAGE);return;}
		if (!acceleration_field.getText().equals("")){acceleration_field.setBackground(Color.WHITE);try {accel=Double.parseDouble(acceleration_field.getText());}catch (NumberFormatException e1){JOptionPane.showMessageDialog(this, "Enter numerical value","EROOR",JOptionPane.INFORMATION_MESSAGE);acceleration_field.setBackground(Color.ORANGE);	}}else {acceleration_field.setBackground(Color.RED);JOptionPane.showMessageDialog(this, "Invalid Content please enter Information","EROOR",JOptionPane.ERROR_MESSAGE);return;}
		if (!speedMax.getText().equals("")){speedMax.setBackground(Color.WHITE);try {this.max_speed=Double.parseDouble(speedMax.getText());}catch (NumberFormatException e1){JOptionPane.showMessageDialog(this, "Enter numerical value","EROOR",JOptionPane.INFORMATION_MESSAGE);speedMax.setBackground(Color.ORANGE);}}else {speedMax.setBackground(Color.RED);JOptionPane.showMessageDialog(this, "Invalid Content please enter Information","EROOR",JOptionPane.ERROR_MESSAGE);return;}
		
		api.addRacer((String) comboBox_1.getSelectedItem(), name, max_speed, accel, utilities.EnumContainer.Color.BLUE);
		
	}
	
	

}
