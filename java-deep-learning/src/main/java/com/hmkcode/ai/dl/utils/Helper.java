package com.hmkcode.ai.dl.utils;

public class Helper {

	public static int DECIMALS = 3;
	public static double round(double value){
		
		double factor = Math.pow(10.0, DECIMALS);
		return Math.round(value*factor)/factor;
	}
	

}
