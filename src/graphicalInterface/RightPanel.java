//////////////////////////////
//Autor:
//Nika Jurczuk
//////////////////////////////
package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.math3.complex.Complex;

public class RightPanel extends JPanel {
	private boolean isRunning;
	private CenterPanel centerPanel;
	private JPanel panel1, panel2, panel3, panel4,panel5,panel6;
	private JSpinner elementsSpinner;
	private JSlider speedSlider;
	private JLabel label1, label2, label3, label4, label5;
	private JRadioButton rButtonParametric, rButtonExamples,rButtonDraw;
	private JTextField xTField, yTField;
	private JComboBox comboBoxExaples; 
	private ButtonGroup bGroup;
	static final int SLIDER_MIN = 0;
    static final int SLIDER_MAX = 100;
    static final int SLIDER_INIT = 50;
    
	public RightPanel(CenterPanel cent) {
		centerPanel=cent;
		isRunning=false;
		this.setLayout(new GridLayout(9,1));
	    
		//PANEL 1 slider
			    panel1 = new JPanel();
			    panel1.setLayout(new FlowLayout());
			    
			    label1= new JLabel("Szybkoœæ animacji");
			    speedSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
			    speedSlider.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						centerPanel.setSpeed((double)speedSlider.getValue()/1000);
					}
			    	
			    });
		        speedSlider.setPreferredSize(new Dimension(150,50));		        
		        panel1.add(label1);
		        panel1.add(speedSlider);
		        this.add(panel1);
		        		
		//PANEL 2   spinner
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
		  
		//PANEL 3-5 radio buttons        
		        panel3 = new JPanel();
		        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		        
		        rButtonParametric = new JRadioButton();
		        label4 = new JLabel("x(t)");
		        xTField = new JTextField(7);
		        label5 = new JLabel("y(t)");
		        yTField = new JTextField(7);
		       
		        panel3.add(rButtonParametric);
		        panel3.add(label4);
		        panel3.add(xTField);
		        panel3.add(label5);
		        panel3.add(yTField);
		        this.add(panel3);   
		      //        
		        panel4 = new JPanel();
		        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		        
		        rButtonExamples= new JRadioButton("Przyk³ady");
		        rButtonExamples.setSelected(true);
		        String[] comboBoxContent= {"Nutka","Serce","Kwiatek"};//new String[3];
		        comboBoxExaples = new JComboBox(comboBoxContent);
		        
		        
		        panel4.add(rButtonExamples);
		        panel4.add(comboBoxExaples);
		        this.add(panel4);
		       //
		        rButtonDraw = new JRadioButton("Narysuj");
		        panel5 = new JPanel();
		        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		        panel5.add(rButtonDraw);
		        this.add(panel5);
		      //		     
		        bGroup = new ButtonGroup();
		        bGroup.add(rButtonParametric);   
		        bGroup.add(rButtonExamples);
		        bGroup.add(rButtonDraw);
		        
		//Border
		   		panel3.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
		   		panel4.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
		   		panel5.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));		   		
		//PANEL 6 - checkbox
		   		panel6=new JPanel();
		        panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		        JCheckBox originalChBox= new JCheckBox("Poka¿ orygina³");
		        originalChBox.setSelected(true);
		        panel6.add(originalChBox);
		        this.add(panel6);

		//Start/Stop button
		   		JButton startStopButton = new JButton("START/STOP");
		   		startStopButton.addActionListener(new StartStopActionListener());
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
	public class StartStopActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!isRunning) {
				if(rButtonDraw.isSelected()) {
					DrawingFrame drawingFrame=new DrawingFrame();
					drawingFrame.setVisible(true);
				}
				else if(rButtonExamples.isSelected()) {
					
				}
				else {
					
				}
				
		        //TEST potem usun¹c
				Complex[] comp=new Complex[10];
				for(int i=0;i<10;i++) {
					comp[i]=new Complex(Math.random()*150-75,Math.random()*150-75);
				}
				centerPanel.startAnimation(comp);
			}
			else {
				centerPanel.stopAnimation();
			}
			isRunning=!isRunning;
		}
		
	}
}
