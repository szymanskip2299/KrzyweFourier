package graphicalInterface;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Line {

	       private List<Integer> xList;  // Lista wspó³rzêdnych x 
	       private List<Integer> yList;  // Lista wspó³rzêdnych y

	       public Line() {
	          xList = new ArrayList<Integer>();
	          yList = new ArrayList<Integer>();
	       }
	     
	       // Dodawanie punktów do linii
	       public void addPoint(int x, int y) {
	          xList.add(x);
	          yList.add(y);
	       }
	     
	       // Metoda pozwalaj¹ca linii na rysowanie siebie samej, je¿eli bêdzie mia³a dostêp do Graphics2D/Graphics
	       public void draw(Graphics g) { 
	    	  int n= xList.size();
	          for (int i = 0; i < n - 1; ++i) 
	          {
	             g.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
	          }
	          g.drawLine(xList.get(n-1),yList.get(n-1),xList.get(n-1),yList.get(n-1));//rysuje punkt jak klikniemy a nie przesuniemy myszk¹
	       }
	       
	       public int getLength() {
	    	   return xList.size();
	       }
	       public int getX(int i) {
	    	   return xList.get(i);
	       }
	       public int getY(int i) {
	    	   return yList.get(i);
	       }
	}
