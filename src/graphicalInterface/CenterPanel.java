package graphicalInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.commons.math3.complex.Complex;

public class CenterPanel extends JPanel {
	private Complex[] an; // tablica wspo³czynnikow we wzorze fouriera, w kolejnosci 0,1,-1,2,-2 itd
	private Timer timer;
	private double speed;
	private Color lineColor;
	public CenterPanel() {
		lineColor=Color.black;
		speed=0.05;
	}
	public CenterPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public CenterPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public CenterPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	public void setSpeed(double sp) {
		speed=sp;
	}
	public void startAnimation(Complex[] comp) {
		an=comp;
		timer=new Timer(33,null);
		timer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
			
		});
		timer.start();
	}
	public void stopAnimation() {
		an=null;
		repaint();
		timer.stop();
	}
	public void update() {
		for(int i=0;i<an.length;i++) {
			if(i%2==1) {//nieparzyste kreca sie nizgodnie do wskazówek zegara
				an[i]=an[i].multiply(new Complex(0,speed*Math.ceil((double)i/2)).exp());
			}
			else {
				an[i]=an[i].multiply(new Complex(0,-speed*Math.ceil((double)i/2)).exp());
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		if(an!=null) {
			g2d.setColor(lineColor);
			int startPointX=(int) getWidth()/2;
			int startpointY= (int) getHeight()/2;
			for(int i=0;i<an.length-1;i++) {
				int endPointX=(int)(startPointX+an[i].getReal());
				int endPointY=(int)(startpointY-an[i].getImaginary());//minus jest bo w javie os Y idzie w dól a w matematyce w góre
				g2d.drawLine(startPointX,startpointY,endPointX,endPointY);
				startPointX=endPointX;
				startpointY=endPointY;
			}
		}
	}

}
