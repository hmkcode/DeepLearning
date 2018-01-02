package com.hmkcode.ai.dl;

import java.util.LinkedList;
import java.util.List;

import com.hmkcode.ai.dl.math.Matrix;
import com.hmkcode.ai.dl.utils.Helper;

public class Network {

	
	private Matrix inputs;
	private List<Matrix> weights;
	private Matrix outputs;
	
	
	
	public void forward(int s){
		

		Matrix input = inputs.getRow(s);
		Matrix predict = null;
		Matrix output = outputs.getRow(s);
		
		input = inputs.getRow(s);
		predict = input;
		for(int w = 0 ; w < weights.size(); w++)
			predict = predict.dot(weights.get(w));
		
		Matrix delta = predict.subtract(output);
		
		Matrix wDelta = input.getVector(0, Matrix.ROW).product(delta.getVector(0, Matrix.ROW));
		

		System.out.println("Network");
		System.out.println("-------------");
		System.out.println("inputs: "+input);
		System.out.println("predicts: "+predict);
		System.out.println("deltas: "+delta);
		System.out.println("wDelta: "+wDelta);
		System.out.println("alpha x wDelta: "+wDelta.dot(0.01));
		System.out.println("weights: "+weights.get(0).T());
		Helper.DECIMALS = 1;
		weights.set(0, (weights.get(0).T().subtract(wDelta.dot(0.01))).T());

		System.out.println("updated weights: "+weights.get(0).T());


	}


	public void addLayer(Matrix weight){
		if(weights == null)
			weights = new LinkedList<Matrix>();
		
		weights.add(weight);
	}
	
	public void train(Matrix inputs, Matrix outputs){
		
		this.inputs = inputs;
		this.outputs = outputs;
		
		forward(0);
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
