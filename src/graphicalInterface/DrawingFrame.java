//////////////////////////////
//Autor:
//Pawe³ Szymañski
//////////////////////////////
package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

public class DrawingFrame extends JFrame {
	private DrawingPanel drawingPanel;
	private CenterPanel centerPanel;
	private RightPanel rightPanel;
	private int elements;
	public DrawingFrame(CenterPanel cent,RightPanel right,int el) throws HeadlessException {
		elements=el;
		centerPanel=cent;
		rightPanel=right;
		setSize(620,600);
		setLayout(new BorderLayout());
		
		
		drawingPanel=new DrawingPanel();
		add(drawingPanel);
		
		JPanel bottomPanel=new JPanel();
		add(bottomPanel,BorderLayout.PAGE_END);
		JButton okButton=new JButton("ZatwierdŸ");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Complex[] an=MathClass.fourier(drawingPanel.getPoints(),elements);
				centerPanel.startAnimation(an);
				List<Line>lines= drawingPanel.getLines();
				for(Line i: lines) {
					i.addToAll((int) ((centerPanel.getWidth()*0.5)-(drawingPanel.getWidth()*0.5)), //centrujemy na œrodek ekranu
							(int) ((centerPanel.getHeight()*0.5)-(drawingPanel.getHeight()*0.5)) );
				}
				centerPanel.setOriginal(lines);
				rightPanel.setRunning(true);
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
