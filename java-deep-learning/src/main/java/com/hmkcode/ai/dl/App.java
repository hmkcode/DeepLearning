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
		
			double[][] outputs = {
				{0.1, 0.0, 0.0, 0.1},
				{1.0, 1.0, 0.0, 1.0},
				{0.1, 0.0, 0.1, 0.2}
			};

			
			Network network = new Network();
			
			network.setInputs(new Matrix(inputs).T());
			network.setOutputs(new Matrix(outputs).T());
			
			network.addWeightMatrix(new Matrix(w0).T());
			network.addWeightMatrix(new Matrix(w1).T());
			
			network.forward();

			
	}
	
}