package graphicalInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseMotionListener, MouseListener{

	private List<Line> lines;
	
	public DrawingPanel() {
		super();
		lines= new ArrayList<Line>();  
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
	}	

	public DrawingPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public DrawingPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public DrawingPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		Graphics2D g2d= (Graphics2D) g;
        for (int i = 0; i <lines.size(); ++i) {
        	lines.get(i).draw(g2d);
        }

	}

	public void reset() {
		lines= new ArrayList<Line>();
		repaint();
	}
	
	public int[][] getPoints(){ //ta funkcja zwaraca macierz gdzie kazda klumna odpowiada jednemu punktowi do ca³ki
		int size=0;
		for(Line line:lines) { //liczymy sume dlugosci wszystkich liñ
			size+=line.getLength();
		}
		int[][] points=new int[size][2];
		int j=0;
		for(Line line:lines) {    //bierzemy wszsytkie punkty z wszystkich lin do jednej 
			for(int i=0;i<line.getLength();i++) {
				points[j][0]=line.getX(i)-(int)(getWidth()/2);    //punkty maja wspólrzedne jak w kartezjanskim o srodku w srodku panelu
				points[j][1]=-line.getY(i)+(int)(getHeight()/2);
				j++;
			}
		}
		return points;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		lines.get(lines.size()-1).addPoint(e.getX(),e.getY());
		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		lines.add(new Line());
		lines.get(lines.size()-1).addPoint(e.getX(),e.getY());
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
