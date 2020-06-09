package graphicalInterface;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

public class Examples extends JPanel {
	
	int[] x= {301, 300, 299, 298, 297, 296, 295, 294, 293}; //na razie przykladowe
	int[] y ={286, 286, 286, 286, 286, 286, 286, 286, 286};


	//Line line;
	 ArrayList<Line> lines;
	ArrayList<Integer> xL;
	ArrayList<Integer> yL;
	private int elements;
	
	public Examples(int el) {
		el=elements;

		lines= new ArrayList<Line>();
		
    	 xL = new ArrayList<>();
    	 yL  = new ArrayList<>();
    	 
	for(int i=0;i<=x.length-1; i++)
    	 
	{	
    	xL.add(x[i]);
    	yL.add(y[i]);
    	}
	for(Line line:lines) {
	
			line.setxList(xL); // tu nie dodaje :/
			line.setyList(yL);
	}	  			
	System.out.println(xL);
	System.out.println(yL);
	System.out.println(lines);

	}	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		Graphics2D g2d= (Graphics2D) g;
        for (int i = 0; i <lines.size()-1; ++i) {
        	lines.get(i).draw(g2d);
        }

	    
	}

//	public Complex[] getPoints(){ //ta funkcja zwaraca macierz gdzie kazda klumna odpowiada jednemu punktowi do ca³ki
//		int size=0;
//		for(Line line:lines) { //liczymy sume dlugosci wszystkich liñ
//			size+=line.getLength();
//		}
//		Complex[] points=new Complex[size];
//		int j=0;
//		for(Line line:lines) {    //bierzemy wszsytkie punkty z wszystkich lin do jednej 
//			for(int i=0;i<line.getLength();i++) {
//				int x=line.getX(i)-(int)(getWidth()/2);    //punkty maja wspólrzedne jak w kartezjanskim o srodku w srodku panelu
//				int y=-line.getY(i)+(int)(getHeight()/2);
//				points[j]=new Complex(x,y);
//				j++;
//				System.out.println(line);
//			}
//		}
//		return points;
//}
	public List<Line> getLines(){
		return lines;
	}	 
}
