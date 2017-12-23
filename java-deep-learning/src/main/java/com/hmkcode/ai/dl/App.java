package com.hmkcode.ai.dl;

import com.hmkcode.ai.dl.math.Matrix;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	double[][] inputs = {
    			{8.5, 9.5, 9.9, 9.0},
    			{0.65,0.8, 0.8, 0.9},
    			{1.2, 1.3, 0.5, 1.0}};

    	double[][] weights  = {
    			{0.1, 0.1, -0.3},
				{0.1, 0.2, 0.0},
				{0.0, 1.3, 0.1}};
    	
        Matrix inputsMatrix = new Matrix(inputs);
        Matrix weightsMatrix = new Matrix(weights);

        System.out.println(inputsMatrix.T());
        System.out.println(weightsMatrix);

        System.out.println(inputsMatrix.T().dot(weightsMatrix.T()));
    }
}
