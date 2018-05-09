package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import game.racers.Racer;
import utilities.Point;



public class JTableBasiqueAvecModeleStatiqueObjet extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public JTableBasiqueAvecModeleStatiqueObjet() {
        super();
 
        setTitle("JTable avec modèle statique et des objets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JTable tableau = new JTable(new ModeleStatiqueObjet());
 
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
 
        pack();
    }
 
    public static void main(String[] args) {
        new JTableBasiqueAvecModeleStatiqueObjet().setVisible(true);
    }

    public class ModeleStatiqueObjet extends AbstractTableModel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private final List infos = new List();
		private ArrayList<Racer> racerList;
        private final String[] entetes = {"Name", "CurrentSpeed", "MaxSpeed", "CurrentLocation X", "Isfinish"};
     
        public ModeleStatiqueObjet() {
        	infos.add(new Info("o", 43, 23, 23, true));
        }
     
        public int getRowCount() {
            return infos.size();
        }
     
        public int getColumnCount() {
            return entetes.length;
        }
     
        public String getColumnName(int columnIndex) {
            return entetes[columnIndex];
        }
     
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch(columnIndex){
                case 0:
                    return infos[rowIndex].getName();
                case 1:
                    return infos[rowIndex].getCurrentSpeed();
                case 2:
                    return infos[rowIndex].getMaxSpeed();
                case 3:
                    return infos[rowIndex].getCurrentLocationx();
                case 4:
                    return infos[rowIndex].isIsfinish();
                default:
                    return null; //Ne devrait jamais arriver
            }
        }
    }
		    
		    
		    public class Info {
		        private String name;
		    	private double currentLocationx;
		    	private double maxSpeed;
		    	private double currentSpeed;
		    	private boolean isfinish;
		    	
		    	
		    	
				public Info(String name, double currentLocationx, double maxSpeed, double currentSpeed,
						boolean isfinish) {
					super();
					this.name = name;
					this.currentLocationx = currentLocationx;
					this.maxSpeed = maxSpeed;
					this.currentSpeed = currentSpeed;
					this.isfinish = isfinish;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public double getCurrentLocationx() {
					return currentLocationx;
				}
				public void setCurrentLocationx(double currentLocationx) {
					this.currentLocationx = currentLocationx;
				}
				public double getMaxSpeed() {
					return maxSpeed;
				}
				public void setMaxSpeed(double maxSpeed) {
					this.maxSpeed = maxSpeed;
				}
				public double getCurrentSpeed() {
					return currentSpeed;
				}
				public void setCurrentSpeed(double currentSpeed) {
					this.currentSpeed = currentSpeed;
				}
				public boolean isIsfinish() {
					return isfinish;
				}
				public void setIsfinish(boolean isfinish) {
					this.isfinish = isfinish;
				}
		    	
		    	
		    }    
		    
		    
}