package graphics;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class ControlPane extends JPanel implements ActionListener {

	public ArenalPanel onep;
	public RacerPanel twop;
	public CtrlPanel threep;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ControlPane() {
		ArenalPanel onep=new ArenalPanel();
		RacerPanel twop=new RacerPanel();
		CtrlPanel threep=new CtrlPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(200, 500));
		onep.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		twop.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		threep.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		
		add(onep);
		add(twop);
		add(threep);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
