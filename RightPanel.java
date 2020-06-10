//////////////////////////////
//Autor:
//Nika Jurczuk
//////////////////////////////
package graphicalInterface;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private Lemniskata ex;
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
		        elementsSpinner = new JSpinner(new SpinnerNumberModel(10,0,100,1)); 
		        
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
		        String[] comboBoxContent= {"Lemniskata Bernoulliego","Trifolium","Kardioida"};//new String[3];
		        comboBoxExaples = new JComboBox(comboBoxContent);	       
		        
		        
		        panel4.add(rButtonExamples);
		        panel4.add(comboBoxExaples);
		        this.add(panel4);
		       //
		        rButtonDraw = new JRadioButton("Narysuj");
		        rButtonDraw.setSelected(true);
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
		        originalChBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						centerPanel.setShowingOriginal(originalChBox.isSelected());
					}
		        	
		        });
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
				int elements=(int)elementsSpinner.getValue();

				if(rButtonDraw.isSelected()) {
					DrawingFrame drawingFrame=new DrawingFrame(centerPanel,RightPanel.this,elements);
					drawingFrame.setVisible(true);
					
				}
				else if(rButtonExamples.isSelected()) {

	                String selected = (String) comboBoxExaples.getSelectedItem();
	         
	                if (selected.equals("Lemniskata Bernoulliego")) {
	                	Lemniskata lem = new Lemniskata(centerPanel, elements);
	                	lem.setVisible(true);
	                	
	                }	                	
	                else if (selected.equals("Trifolium")) {
	                	
	                	Trifolium trif = new Trifolium(centerPanel, elements);
	                	trif.setVisible(true);
	   				 }
	   			
	                
	                else if (selected.equals("Kardioida")) {
	                	Kardioida kar = new Kardioida(centerPanel, elements);
	                	kar.setVisible(true);
	                }				
				}
				
				else {
					try {
					double points[][]=MathClass.parametricPoints(xTField.getText(), yTField.getText());
					ArrayList<Line> lines=new ArrayList<Line>();
					Line line=new Line();
					Complex data[]=new Complex[points.length];
					for(int i=0;i<data.length;i++) {
						line.addPoint((int)points[i][0],-(int)points[i][1]);
						data[i]=new Complex(points[i][0],points[i][1]);
					}
					line.addToAll((int)(centerPanel.getWidth()*0.5),(int)(centerPanel.getHeight()*0.5) );
					lines.add(line);
					Complex an[]=MathClass.fourier(data,(int)elementsSpinner.getValue());
					centerPanel.setOriginal(lines);
					centerPanel.startAnimation(an);
					isRunning=!isRunning;
					}
					catch(IllegalArgumentException exc) {
						JOptionPane.showMessageDialog(new JFrame(),
							    "B³êdnie wpisane równanie parametryczne",
							    "B³¹d",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
			else {
				centerPanel.stopAnimation();
				isRunning=!isRunning;
			}
			
        
			
		}
		
	}
	public void setRunning(boolean b) {
		isRunning=b;
	}
}
