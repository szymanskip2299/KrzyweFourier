package graphicalInterface;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Line {

	       private ArrayList<Integer> xList;  // Lista wsp�rz�dnych x 
	       private ArrayList<Integer> yList;  // Lista wsp�rz�dnych y


	       public Line() {
	          xList =new ArrayList<Integer>();
	          yList = new ArrayList<Integer>();
	       }
	     
	       // Dodawanie punkt�w do linii
	       public void addPoint(int x, int y) {
	          xList.add(x);
	          yList.add(y);
	       }
	     
	       // Metoda pozwalaj�ca linii na rysowanie siebie samej, je�eli b�dzie mia�a dost�p do Graphics2D/Graphics
	       public void draw(Graphics g) { 
	    	  int n= xList.size();
	          for (int i = 0; i < n - 1; ++i) 
	          {
	             g.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
	          }
	          g.drawLine(xList.get(n-1),yList.get(n-1),xList.get(n-1),yList.get(n-1));//rysuje punkt jak klikniemy a nie przesuniemy myszk�
	       }
	       
	       public int getLength() {
	    	   return xList.size();
	       }
//	       public void setxList(ArrayList<Integer> l)
//	       {
//	    	   xList=l;
//	       }
//	       public void setyList(ArrayList<Integer> ll)
//	       {
//	    	   yList=ll;
//	       }
	       public int getX(int i) {
	    	   return xList.get(i);
	       }

	       public int getY(int i) {
	    	   return yList.get(i);
	       }
	       public void addToAll(int x,int y) {
	    	   for(int i=0;i<xList.size();i++) {
	    		   xList.set(i, xList.get(i)+x);
	    		   yList.set(i, yList.get(i)+y);
	    	   }
	       }
	       public void deleteLast() {
	    	   xList.remove(0);
	    	   yList.remove(0);
	       }
	       public void wypisz() // to zeby wziac punkty do przykladu
	       {
	    	  for (int i=0;i<xList.size();i++)
	    	  {
	    		 System.out.print(xList.get(i)+", ");
	    	  }	  
	    	  System.out.print("\n");
	    	  for (int i=0;i<yList.size();i++)
	    	  {
	    		 System.out.print(yList.get(i)+", ");


	    	  }	  

	       }}
		

