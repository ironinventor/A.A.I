package com.AceAI;

import java.util.ArrayList;

public class Network {

    private ArrayList<Neuron> neurons;

    public Network() {
        neurons = new ArrayList<>();
    }

    public void addNeurons(int count) {
        for (int i = 0; i < count; i++) {
            neurons.add(new Neuron());
        }
    }

    public void setInputs(ArrayList<Integer> inputs) {
        for (Neuron n : neurons)
            n.setInputs(inputs);
    }

    public ArrayList<Double> getOutputs() {
        ArrayList<Double> outputs = new ArrayList<>();
        for (Neuron n : neurons)
            outputs.add(n.getOutput());

        return outputs;
    }

    public void adjustWeights(ArrayList<Double> goodOutput) {
    	for (int i = 0; i < 26; i++) {
            double delta = goodOutput.get(i) - neurons.get(i).getOutput();
            neurons.get(i).adjustWeights(delta);
        }
    }
    
    public ArrayList<Neuron> getNeurons() {
    	return neurons;
    }
    
    public void setNeurons(ArrayList<Neuron> neurons) {
    	this.neurons = neurons;
    }

}
