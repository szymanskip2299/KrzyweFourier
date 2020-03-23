package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class RightPanel extends JPanel {

	private JPanel rightPanel, centerPanel, panel1, panel2, panel3, panel4,panel5,panel6,panel7;
	private JSpinner elementsSpinner;
	private JSlider speedSlider;
	private JLabel label1, label2, label3, label4, label5;
	private JRadioButton rbutton1, rbutton2,rbutton3, rbutton4;
	private JTextField xTField, yTField;
	private JComboBox box; 
	private ButtonGroup bGroup;
	static final int SLIDER_MIN = 0;
    static final int SLIDER_MAX = 100;
    static final int SLIDER_INIT = 10;
    
	public RightPanel() {
		this.setLayout(new GridLayout(10,1));
	    
		//FIRST PANEL
			    panel1 = new JPanel();
			    panel1.setLayout(new FlowLayout());
			    
			    label1= new JLabel("Szybkoœæ animacji");
			    speedSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		        speedSlider.setPreferredSize(new Dimension(150,50));		        
		        panel1.add(label1);
		        panel1.add(speedSlider);
		        this.add(panel1);
		        		
		//PANEL 2       
		        panel2 = new JPanel();
		        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		        
		        label2 = new JLabel("Iloœæ elementów");
		        elementsSpinner = new JSpinner(new SpinnerNumberModel(50,0,100,1));  
		        
		        panel2.add(label2);
		        panel2.add(elementsSpinner);
		        this.add(panel2);
		        
		 //       
		    label3 = new JLabel("Wprowadzanie:");
		    this.add(label3);
		//
		  
		//PANEL 3-6 radio buttons        
		        panel3 = new JPanel();
		        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		        
		        bGroup = new ButtonGroup();
		        
		        rbutton1 = new JRadioButton();
		        label4 = new JLabel("x(t)");
		        xTField = new JTextField(7);
		        label5 = new JLabel("y(t)");
		        yTField = new JTextField(7);
		       
		        panel3.add(rbutton1);
		        panel3.add(label4);
		        panel3.add(xTField);
		        panel3.add(label5);
		        panel3.add(yTField);
		        this.add(panel3);   
		      //        
		        panel4 = new JPanel();
		        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		        
		        rbutton2= new JRadioButton("Przyk³ady");
		        box = new JComboBox();
		        
		        panel4.add(rbutton2);
		        panel4.add(box);
		        this.add(panel4);
		       //
		        rbutton3 = new JRadioButton("Narysuj");
		        panel5 = new JPanel();
		        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		        panel5.add(rbutton3);
		      //
		        rbutton4 = new JRadioButton("Otwórz z pliku");

		        panel6 = new JPanel();
		        panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		        panel6.add(rbutton4);
		        this.add(panel5);
		        this.add(panel6);
		      //		     
		        bGroup.add(rbutton1);   
		        bGroup.add(rbutton2);
		        bGroup.add(rbutton3);
		        bGroup.add(rbutton4);
		        
		//Border
		   		panel3.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
		   		panel4.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
		   		panel5.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
		   		panel6.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
		   		
		//PANEL 7 - checkbox
		   		panel7=new JPanel();
		        panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
		        JCheckBox originalChBox= new JCheckBox("Poka¿ orygina³");
		        originalChBox.setSelected(true);
		        panel7.add(originalChBox);
		        this.add(panel7);

		//Start/Stop button
		   		JButton startStopButton = new JButton("START/STOP");
		   		this.add(startStopButton);
	}

	public RightPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public RightPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public RightPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
