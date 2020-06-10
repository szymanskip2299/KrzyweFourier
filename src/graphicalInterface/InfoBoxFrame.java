//////////////////////////////
//Autor:
//Pawe³ Szymañski
//////////////////////////////

package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoBoxFrame extends JFrame {

	public InfoBoxFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public InfoBoxFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}
	public InfoBoxFrame(String title,String info) throws HeadlessException {
		super(title);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setSize(290,100);
		this.add(new JLabel(info),BorderLayout.CENTER);
		JButton okButton=new JButton("Ok");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(okButton);
		this.add(buttonPanel,BorderLayout.PAGE_END);

	}

	public InfoBoxFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public InfoBoxFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
