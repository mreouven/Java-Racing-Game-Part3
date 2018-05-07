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
	private ControlPane paneles;
	
	
	 public static void main(String[]args)
	   {
		 ArenaFrame arenaFrame = new ArenaFrame();
		 arenaFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 arenaFrame.setSize(1000,800);
		 arenaFrame.setResizable(false);
		 arenaFrame.setVisible(true);
		
		 
	   }
	public ArenaFrame() {
		
		super("Arena");
		this.setLayout(new BorderLayout());
		
		panel =new ArenaPanel(this);
		paneles =new ControlPane(this);
		//getContentPane().add(panel,);
		getContentPane().add(paneles);
	    panel.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	

}
