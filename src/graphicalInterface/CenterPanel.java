//////////////////////////////
//Autor:
//Pawe³ Szymañski
//////////////////////////////
package graphicalInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;
import org.apache.commons.math3.complex.Complex;


public class CenterPanel extends JPanel {
	private Complex[] an; // tablica wspo³czynnikow we wzorze fouriera, w kolejnosci 0,1,-1,2,-2 itd
	private Timer timer;
	private double speed;
	public Color lineColor;
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
	
	  public void setColor(Color c) {
	        this.lineColor = c;
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
//		for(Line line : original) {
//			line.wypisz();
//		}
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
		g2d.setBackground(Color.white);
		g2d.setColor(lineColor);
		if(an!=null) {
			g2d.setColor(lineColor);
			Complex sum=new Complex(getWidth()/2,getHeight()/2);
			for(int i=0;i<an.length;i++) {
				int startPointX=(int) sum.getReal();
				int startpointY= (int) sum.getImaginary();
				sum=sum.add(an[i].conjugate());
				int endPointX=(int) sum.getReal();
				int endPointY= (int) sum.getImaginary();//minus jest bo w javie os Y idzie w dól a w matematyce w góre
				g2d.drawLine(startPointX,startpointY,endPointX,endPointY);
		


				}
			
			
			
			trace.addPoint((int) sum.getReal(), (int) sum.getImaginary());
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
