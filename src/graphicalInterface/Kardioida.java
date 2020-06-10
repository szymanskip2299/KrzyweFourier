package graphicalInterface;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

public class Kardioida extends JPanel {
	
	int[] x=new int[1000];
	int[] y=new int[1000];

	 ArrayList<Line> lines;
	
	private int elements;
	private CenterPanel centerPanel;
	
	public Kardioida(CenterPanel cent,int el) {
		elements=el;
		centerPanel=cent;
		int t;
    	for(t=0;t<=x.length-1;t+=5)	 {
			double xx=150*(1-Math.cos(t))*(Math.cos(t));
			double yy=150*Math.sin(t)*(1-Math.cos(t));
			x[t]=(int)xx;
			y[t]=(int)yy;	
		 }
    	
		lines= new ArrayList<Line>();
		Line line = new Line();
    	
		for(int i=0;i<=x.length-1; i++) {	
			line.addPoint(x[i], y[i]);
		}
		
		lines.add(line);
		line.addToAll((int)(centerPanel.getWidth()*0.7),(int)(centerPanel.getHeight()*0.5) );
		Complex[] an=MathClass.fourier(getPoints(),elements);
		centerPanel.startAnimation(an);
		centerPanel.setOriginal(lines);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		Graphics2D g2d= (Graphics2D) g;
        for (int i = 0; i <lines.size()-1; ++i) {
        	lines.get(i).draw(g2d);
        }    
	}

	public Complex[] getPoints(){ //ta funkcja zwaraca macierz gdzie kazda klumna odpowiada jednemu punktowi do ca�ki
		int size=0;
		for(Line line:lines) { //liczymy sume dlugosci wszystkich li�
			size+=line.getLength();
		}
		Complex[] points=new Complex[size];
		int j=0;
		for(Line line:lines) {    //bierzemy wszsytkie punkty z wszystkich lin do jednej 
			for(int i=0;i<line.getLength();i++) {
				int x=line.getX(i)-(int)(getWidth()/2);    //punkty maja wsp�lrzedne jak w kartezjanskim o srodku w srodku panelu
				int y=-line.getY(i)+(int)(getHeight()/2);
				points[j]=new Complex(x,y);
				j++;
			}
		}
		return points;	
}
	
	public List<Line> getLines() {
		return lines;
	}	
}
