package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import game.racers.Racer;
import utilities.EnumContainer.Arena;

public class ControlPanel extends JPanel implements ActionListener {

	
	private final static String[] arenaList = { "Land Arena", "Naval Arena", "Aeral Arena"};
	private ArenaFrame frame;
	private JComboBox<String> arenaChoice;
	
	
	public ControlPanel(ArenaFrame f) {
		
		setFrame(f);
		
		setBackground(Color.WHITE);
		arenaChoice =new JComboBox<String>(arenaList);
		arenaChoice.setSelectedItem(3);
		arenaChoice.addActionListener(this);
		arenaChoice.setBounds(621, 45, 171, 41);
		this.add(arenaChoice, "list");
		
		
		
		
	}
	private void setFrame(ArenaFrame f) {
		frame=f;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
