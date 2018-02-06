package com.hmkcode.ai.dl;	
	
import com.hmkcode.ai.dl.math.Matrix;

public class App
{
	public static void main( String[] args )
	{
			double[][] inputs = {
					{2.0,3.0}
			};
			
			double weights_1[][] = { 
					{0.11,0.21},
					{0.12,0.08}
			};
			double weights_2[][] = { 
					{0.14,0.15}
			};
		

			double[][] outputs = {
				{1},
			};

			
			Network network = new Network();
			
			network.addLayer(new Matrix(weights_1).T());
			network.addLayer(new Matrix(weights_2).T());
			
			network.train(new Matrix(inputs), new Matrix(outputs));

			
	}
	
}