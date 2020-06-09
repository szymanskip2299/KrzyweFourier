////////////////////////
//Autor: Nika Jurczuk //
////////////////////////

package graphicalInterface;



import org.apache.commons.math3.complex.Complex;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MathClass {

	public static Complex[] multiplyTable(Complex[] data,int n){
		Complex[] wynik=new Complex[n*data.length];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<n;j++) {
				wynik[j+i*n]=data[i];
			}
		}
		return wynik;
	}
	
	public static double[][] parametricPoints(String xExp,String yExp){
		Expression xExpression= new ExpressionBuilder(xExp).variables("t").build();
		Expression yExpression= new ExpressionBuilder(yExp).variables("t").build();
		double data[][]=new double[1000][2];
		for(int ii=0;ii<1000;ii++) {
			xExpression.setVariable("t", (ii+0.5)/1000);
			yExpression.setVariable("t", (ii+0.5)/1000);
			data[ii][0]=xExpression.evaluate();
			data[ii][1]=yExpression.evaluate();
		}
		return data;
				
	}
	
	
	public static Complex[] fourier(Complex[] data,int elements){
		int L = data.length;
		Complex[] fourier = new Complex[elements];
		if(data.length<10*elements) {  //jak data jest za mala to tworzy bardzo niedokladne wyniki
			int ile_razy=(int)(10*elements/data.length);
			data=multiplyTable(data,ile_razy);
		}
		
		for (int n = 0; n < elements; n++) {//liczy wspo³czynniki w kolejnosci 0,1,-1,2,-2,itd
			Complex sum=new Complex(0,0);
			
			int index;//nr wspolczynika we wzorze fouriera
			if(n%2==1) {
				index=(int) Math.ceil((double)n/2);
			}
			else {
				index=-(int)Math.ceil((double)n/2);
			}
			
			for (int j = 0; j < L; j++) {
				sum=sum.add(data[j].multiply(Complex.I.multiply(-index*2*Math.PI*(j)/L).exp()));
			}
			fourier[n]=sum.divide(L);
		}
		
		return fourier;
	}
	
	
}

