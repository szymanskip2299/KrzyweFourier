package po;

import javax.swing.*;
import java.awt.*;


public class Fourier extends JFrame
{
	private JPanel rightPanel, centerPanel, firstPanel, secondPanel, thirdPanel, fourthPanel;
	private JSpinner spinner;
	private JSlider slider;
	private JLabel label1, label2, label3, label4, label5;
	private JRadioButton rbutton1, rbutton2,rbutton3, rbutton4;
	private JTextField tfield1, tfield2;
	private JComboBox box; 
	private ButtonGroup bGroup;
	
	static final int SLIDER_MIN = 0;
    static final int SLIDER_MAX = 100;
    static final int SLIDER_INIT = 10;
    
    public Fourier()
    {
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.setSize(900,600);
	    this.setLayout(new BorderLayout());
	    
//right panel
	    rightPanel = new JPanel();
	    rightPanel.setLayout(new GridLayout(9,1));
	    
//FIRST PANEL
	    firstPanel = new JPanel();
	    firstPanel.setLayout(new FlowLayout());
	    
	    label1= new JLabel("Elementy");
	    slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        slider.setPreferredSize(new Dimension(150,50));
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        firstPanel.add(label1);
        firstPanel.add(slider);
        rightPanel.add(firstPanel);
        		
//SECOND PANEL       
        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        label2 = new JLabel("Szybkoœæ");
        spinner = new JSpinner();  
        
        secondPanel.add(label2);
        secondPanel.add(spinner);
        rightPanel.add(secondPanel);
        
 //       
    label3 = new JLabel("Wprowadzanie");
    rightPanel.add(label3);
//
  
//THIRD PANEL        
        thirdPanel = new JPanel();
        thirdPanel.setLayout(new FlowLayout());
        
        bGroup = new ButtonGroup();
        
        rbutton1 = new JRadioButton();
        label4 = new JLabel("x(t)");
        tfield1 = new JTextField(7);
        label5 = new JLabel("y(t)");
        tfield2 = new JTextField(7);
  
        thirdPanel.add(rbutton1);
        thirdPanel.add(label4);
        thirdPanel.add(tfield1);
        thirdPanel.add(label5);
        thirdPanel.add(tfield2);
        rightPanel.add(thirdPanel);   
   
//FOURTH PANEL        
        fourthPanel = new JPanel();
        fourthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        rbutton2= new JRadioButton("Przyk³ady");
        box = new JComboBox();
        
        fourthPanel.add(rbutton2);
        fourthPanel.add(box);
        rightPanel.add(fourthPanel);
//       
   rbutton3 = new JRadioButton("Narysuj");
   rbutton4 = new JRadioButton("Otwórz z pliku");
   
   rightPanel.add(rbutton3);
   rightPanel.add(rbutton4);
//     
   bGroup.add(rbutton1);   
   bGroup.add(rbutton2);
   bGroup.add(rbutton3);
   bGroup.add(rbutton4);
   
   		this.add(rightPanel, BorderLayout.LINE_END);
        
//center panel
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);
      
        this.add(centerPanel,BorderLayout.CENTER);
 	}
	
	public static void main(String[] args) 
	{
		Fourier fourier = new Fourier();
		fourier.setVisible(true);
	}

}
