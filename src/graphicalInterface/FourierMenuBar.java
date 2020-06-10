//////////////////////////////
//Autor:
//Pawe³ Szymañski
//////////////////////////////

package graphicalInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class FourierMenuBar extends JMenuBar {
	
	private JMenu menu;
	CenterPanel centerPanel;
	private JMenuItem lineColorChange,backgroundColorChange;
	
	public FourierMenuBar(CenterPanel cent) {
		centerPanel=cent;
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		this.add(menu);
		JMenuItem autorItem = new JMenuItem("Autorzy");
		autorItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Nika Jurczuk i Pawe³ Szymañski",
					    "Autorzy",
					    JOptionPane.PLAIN_MESSAGE);
			}
			
		});
		menu.add(autorItem);
		menu.addSeparator();
		lineColorChange = new JMenuItem("Zmieñ kolor lini");
		lineColorChange.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	final JColorChooser colorChooser = new JColorChooser();
                JDialog dialog = JColorChooser.createDialog(FourierMenuBar.this, "Choose line color", true, colorChooser, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        centerPanel.lineColor = colorChooser.getColor();
                    }
                }, new ActionListener() 
                	{
                    @Override
                    public void actionPerformed(ActionEvent e)  {}
                    });
                dialog.setVisible(true);
            }
        });

		menu.add(lineColorChange);
		backgroundColorChange = new JMenuItem("Zmieñ kolor t³a");
		  backgroundColorChange.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {
	            	final JColorChooser colorChooser = new JColorChooser();
	                JDialog dialog = JColorChooser.createDialog(FourierMenuBar.this, "Choose background color", true, colorChooser, new ActionListener() 
	                {
	                    @Override
	                    public void actionPerformed(ActionEvent e) 
	                    {
	                        centerPanel.setBackground(colorChooser.getColor());
	                    }
	                }, new ActionListener() 
	                	{
	                    @Override
	                    public void actionPerformed(ActionEvent e) {} 
	                 	});
	                dialog.setVisible(true);
	            }
	        });
	    
		menu.add(backgroundColorChange);
				
	}

		

}
