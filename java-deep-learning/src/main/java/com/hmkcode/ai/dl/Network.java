package com.hmkcode.ai.dl;

import java.util.LinkedList;
import java.util.List;

import com.hmkcode.ai.dl.math.Matrix;
import com.hmkcode.ai.dl.utils.Formatter;

public class Network {

	
	private Matrix inputs;
	private List<Matrix> weights;
	private Matrix outputs;
	
	
	
	public void forward(int s){
		
		Matrix input = inputs.getRow(s);
		Matrix predict = null;
		Matrix output = outputs.getRow(s);
		List<Matrix> layers = new LinkedList<Matrix>();
		List<Matrix> deltas = new LinkedList<Matrix>();

		predict = input;
		System.out.println("weights: "+weights);
		for(int w = 0 ; w < weights.size(); w++){
			layers.add(predict);
			predict = predict.dot(weights.get(w));
		}
		
		Matrix delta = predict.subtract(output);
		
		for(int w = weights.size()-1 ; w >= 0; w--){
			deltas.add(0,delta);
			delta = delta.dot(weights.get(w).T());
		}
		
		
		for(int i = 0 ; i < layers.size(); i++){
			Matrix alphaxinputxdelta = (layers.get(i).T().dot(deltas.get(i))).dot(0.01);
			weights.set(i, weights.get(i).subtract(alphaxinputxdelta));
		}
		System.out.println("inputs: "+layers);
		System.out.println("deltas: "+deltas);
		System.out.println("weights: "+weights);
	}
	
	public void Backpropagate(){
		
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
