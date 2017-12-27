package com.hmkcode.ai.dl;	
	
import com.hmkcode.ai.dl.math.Matrix;

public class App
{
	public static void main( String[] args )
	{
			double[][] inputs = {
				{8.5, 9.5, 9.9, 9.0},
				{0.65,0.8, 0.8, 0.9},
				{1.2, 1.3, 0.5, 1.0}
			};
		
			double[][] w0 = {
				{0.1, 0.2, -0.1},
				{-0.1,0.1, 0.9},
				{0.1, 0.4, 0.1}
			};
			
			double[][] w1 = {
				{0.3, 1.1, -0.3},
				{0.1, 0.2, 0.0},
				{0.0, 1.3, 0.1}
			};
		
		
		
			Matrix inM = new Matrix(inputs).T();
			System.out.println(inM);

			Matrix weights_0 = new Matrix(w0).T();
			System.out.println(weights_0);

			Matrix weights_1 = new Matrix(w1).T();
			System.out.println(weights_1);			

			
			Matrix layer_0 = inM.getRow(0);
			Matrix layer_1 = layer_0.dot(weights_0);
			Matrix output = layer_1.dot(weights_1);
			
			
			System.out.println(layer_0);
			System.out.println(layer_1);
			System.out.println(output);
	}
	
}