////////////////////////
//Autor: Nika Jurczuk //
////////////////////////

package graphicalInterface;

import java.util.ArrayList;

public class MathClass {


	public MathClass() {
		
		public static ArrayList <double[]> fourier(ArrayList <Double> data, double rotation) {
			int N = data.size();
			ArrayList<double[]> fourier = new ArrayList<double[]>();

			for (int k = 0; k < N; k++) {
				double re = 0;
				double im = 0;
				for (int n = 0; n < N; n++) {
					re += data.get(n) * Math.cos((2 * Math.PI * k * n) / N);
					im -= data.get(n) * Math.sin((2 * Math.PI * k * n) / N);
				}
				re = re / N;
				im = im / N;
				double amp = Math.sqrt(re * re + im * im);
				double freq = k;
				double phase = Math.atan2(im, re);
				fourier.add(new double[] {freq, amp, phase, rotation});
			}
			
			return fourier;
		}
	}
	
}

