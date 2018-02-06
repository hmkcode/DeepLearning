package com.hmkcode.ai.dl.math;

import com.hmkcode.ai.dl.utils.Formatter;

public class Vector {

	private double[] values;
	private int length;
	
	public Vector(double[] values){
		this.values = values;
		this.length = this.values.length;
	}
	
	public double dot(Vector vector){
		
		double productSum = 0;
		for(int i = 0; i < values.length; i++)
			productSum += (this.values[i]*vector.values[i]);
		
		//System.out.println(this+" x "+vector+ " =  "+Helper.round(productSum));
		return Formatter.round(productSum);
		
	}
	
	public Matrix product(Vector vector){
		
		double[][] results = new double[this.length][vector.length];
		
		for(int r = 0; r < this.length; r++)
			for(int c = 0 ; c < vector.length; c++)
				results[r][c] = Formatter.round(this.values[r]*vector.values[c]);
		
		return new Matrix(results);
		
	}
	
	public double[] getValues() {
		return values;
	}

	public void setValues(double[] values) {
		this.values = values;
	}

	@Override
	public String toString() {
		String output = "";
		
		for(int i = 0 ; i < this.values.length; i++)
				output += this.values[i]+", ";
					
			
		return output;
	}
}
