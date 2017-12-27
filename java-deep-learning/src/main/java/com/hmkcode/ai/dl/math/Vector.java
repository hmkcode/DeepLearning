package com.hmkcode.ai.dl.math;

import com.hmkcode.ai.dl.utils.Helper;

public class Vector {

	private double[] values;
	
	public Vector(double[] values){
		this.values = values;
	}
	
	public double dot(Vector vector){
		
		double productSum = 0;
		for(int i = 0; i < values.length; i++)
			productSum += (this.values[i]*vector.values[i]);
		
		//System.out.println(this+" x "+vector+ " =  "+Helper.round(productSum));
		return Helper.round(productSum);
		
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
