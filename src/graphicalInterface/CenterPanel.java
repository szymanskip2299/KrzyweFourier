//////////////////////////////
//Autor:
//Pawe³ Szymañski
//////////////////////////////
package graphicalInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;
import org.apache.commons.math3.complex.Complex;





public class CenterPanel extends JPanel {
	private Complex[] an; // tablica wspo³czynnikow we wzorze fouriera, w kolejnosci 0,1,-1,2,-2 itd
	private Timer timer;
	private double speed;
	private Color lineColor;
	private Line trace;
	private List<Line> original;
	private boolean isShowingOriginal;
	public CenterPanel() {
		lineColor=Color.black;
		speed=0.05;
		trace=new Line();
		isShowingOriginal=true;
	}
	public CenterPanel(LayoutManager layout) {
		super(layout);
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
		timer=new Timer(16,null);
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
		trace=new Line();
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
		setBackground(Color.white);
		g2d.setColor(lineColor);
		if(an!=null) {
			g2d.setColor(lineColor);
			int startPointX=(int) getWidth()/2;
			int startpointY= (int) getHeight()/2;
			int endPointX=0;
			int endPointY=0;
			for(int i=0;i<an.length;i++) {
				endPointX=(int)(startPointX+an[i].getReal());
				endPointY=(int)(startpointY-an[i].getImaginary());//minus jest bo w javie os Y idzie w dól a w matematyce w góre
				g2d.drawLine(startPointX,startpointY,endPointX,endPointY);
				startPointX=endPointX;
				startpointY=endPointY;
			}
			
			
			trace.addPoint(endPointX, endPointY);
			if(trace.getLength()>2*Math.PI/speed) {
				trace.deleteLast();
			}
			trace.draw(g2d);
			if(isShowingOriginal) {
				for(Line line:original) {
					line.draw(g2d);
				}
			}
		}
	}
	public void setOriginal(List<Line> lines) {
		original=lines;
		
	}
	public void setShowingOriginal(boolean orig) {
		isShowingOriginal=orig;
	}

}
