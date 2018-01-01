package com.hmkcode.ai.dl;

import java.util.LinkedList;
import java.util.List;

import com.hmkcode.ai.dl.math.Matrix;

public class Network {

	
	private Matrix inputs;
	private List<Matrix> weights;
	private Matrix outputs;
	
	
	
	public void forward(){
		

		Matrix input = null;
		Matrix output = null;
		
		for(int i = 0; i < 1; i++){
			input = inputs.getRow(i);
			output = input;
			for(int w = 0 ; w < weights.size(); w++)
				output = output.dot(weights.get(w));
		}
		
		System.out.println("Network");
		System.out.println("-------------");
		System.out.println("inputs: "+input);
		System.out.println("outputs: "+output);
	}


	public void addWeightMatrix(Matrix weight){
		if(weights == null)
			weights = new LinkedList<Matrix>();
		
		weights.add(weight);
	}
	
	
	public Matrix getInputs() {
		return inputs;
	}



	public void setInputs(Matrix inputs) {
		this.inputs = inputs;
	}



	public List<Matrix> getWeights() {
		return weights;
	}



	public void setWeights(List<Matrix> weights) {
		this.weights = weights;
	}



	public Matrix getOutputs() {
		return outputs;
	}



	public void setOutputs(Matrix outputs) {
		this.outputs = outputs;
	}
	
	
}
