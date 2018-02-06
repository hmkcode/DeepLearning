package com.hmkcode.ai.dl.math;

import com.hmkcode.ai.dl.math.Matrix;

public class Activation {

	public static Matrix relu(Matrix matrix){
		
		double results[][] = new double[matrix.getRows()][matrix.getColumns()];
		
		for(int r = 0 ; r < matrix.getRows(); r++)
			for(int c = 0 ; c < matrix.getColumns(); c++)
				results[r][c] = relu(matrix.getValues()[r][c]);
		
		return new Matrix(results);
	}
	
	public static double relu(double value){
		return (value < 0)?0:value;
	}
}
