package graphics;


import javax.swing.JFrame;

import utilities.EnumContainer.Arena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.BorderLayout;



public class ArenaFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ArenaPanel panel;
	
	
	 public static void main(String[]args)
	   {
		 ArenaFrame arenaFrame = new ArenaFrame();
		 arenaFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 arenaFrame.setSize(800,600);
		 arenaFrame.setResizable(false);
		 arenaFrame.setVisible(true);
		
		 
	   }
	public ArenaFrame() {
		
		super("Arena");
		panel =new ArenaPanel(this);
		getContentPane().add(panel);
	    panel.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	

}
