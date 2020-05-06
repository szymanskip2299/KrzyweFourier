package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingFrame extends JFrame {
	private DrawingPanel drawingPanel;
	public DrawingFrame() throws HeadlessException {
		setSize(620,600);
		setLayout(new BorderLayout());
		
		
		drawingPanel=new DrawingPanel();
		add(drawingPanel);
		
		JPanel bottomPanel=new JPanel();
		add(bottomPanel,BorderLayout.PAGE_END);
		JButton okButton=new JButton("Zatwierdü");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//tutaj powinnien podawac dane do liczenia
				drawingPanel.getPoints();
				dispose();
			}
			
		});
		bottomPanel.add(okButton);
		
		
		JButton resetButton=new JButton("Resetuj");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.reset();
			}
			
		});
		bottomPanel.add(resetButton);
		setVisible(true);
	}

	public DrawingFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public DrawingFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public DrawingFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
