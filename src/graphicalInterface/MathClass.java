////////////////////////
//Autor: Nika Jurczuk //
////////////////////////

package graphicalInterface;



import org.apache.commons.math3.complex.Complex;

public class MathClass {


	
	public static Complex[] fourier(Complex[] data,int elements){
		int L = data.length;
		Complex[] fourier = new Complex[elements];

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

