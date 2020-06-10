//////////////////////////////
//Autor:
//Nika Jurczuk
//////////////////////////////
package graphicalInterface;

import javax.swing.*;

import org.apache.commons.math3.complex.Complex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Fourier extends JFrame
{
	
	private FourierMenuBar menuBar;
	private RightPanel rightPanel;
    private CenterPanel centerPanel;
    public Fourier()
    {
    	
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setSize(900,600);
	    this.setLayout(new BorderLayout());
	    this.setTitle("Krzywe Fouriera");
	    
	  //center panel
        centerPanel = new CenterPanel();
        centerPanel.setBackground(Color.white);
        
        this.add(centerPanel,BorderLayout.CENTER);
	    
//MENU
	    menuBar = new FourierMenuBar(centerPanel);
		this.setJMenuBar(menuBar);;

   		
   		

        
//right panel
      	rightPanel = new RightPanel(centerPanel);
        this.add(rightPanel, BorderLayout.LINE_END);   		
        

 	}
	
	public static void main(String[] args) 
	{
		Fourier fourier = new Fourier();
		fourier.setVisible(true);
		

	}

}
