package graphicalInterface;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Fourier extends JFrame
{
	
	private FourierMenuBar menuBar;

    
    public Fourier()
    {
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.setSize(900,600);
	    this.setLayout(new BorderLayout());
	    
//MENU
	    menuBar = new FourierMenuBar();
		this.setJMenuBar(menuBar);;
//right panel
	    RightPanel rightPanel = new RightPanel();
   		this.add(rightPanel, BorderLayout.LINE_END);   		
   		
   		
//center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);
      
        this.add(centerPanel,BorderLayout.CENTER);
 	}
	
	public static void main(String[] args) 
	{
		Fourier fourier = new Fourier();
		fourier.setVisible(true);
	}

}
