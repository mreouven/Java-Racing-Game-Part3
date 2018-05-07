package graphics;


import javax.swing.JFrame;

import utilities.EnumContainer.Arena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;



public class ArenaFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	
	
	 public static void main(String[]args)
	   {
		 ArenaFrame arenaFrame = new ArenaFrame();
		 arenaFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 arenaFrame.setSize(new Dimension(1300, 1300));
		 //arenaFrame.setResizable(false);
		 arenaFrame.setLocationRelativeTo(null);
		 arenaFrame.setVisible(true);
		
		 
	   }
	public ArenaFrame() {
		
		super("Arena");
		
		
		
		panel =new FinalPanel();
		add(panel);
		
	    panel.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
