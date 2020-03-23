package graphicalInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FourierMenuBar extends JMenuBar {
	private JMenu menu;
	
	public FourierMenuBar() {
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		this.add(menu);
		JMenuItem autorItem = new JMenuItem("Autorzy");
		autorItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final InfoBoxFrame autorFrame=new InfoBoxFrame("Autorzy","Nika Jurczuk i Pawe� Szyma�ski");
			}
			
		});
		menu.add(autorItem);
		menu.addSeparator();
		JMenuItem saveItem= new JMenuItem("Zapisz krzyw�");
		menu.add(saveItem);
		menu.addSeparator();
		JMenuItem lineColorChange = new JMenuItem("Zmie� kolor lini");
		menu.add(lineColorChange);
		JMenuItem backgroundColorChange = new JMenuItem("Zmie� kolor t�a");
		menu.add(backgroundColorChange);
				
	}

		

}
