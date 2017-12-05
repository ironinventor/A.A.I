package neural;

import utils.MathUtils;

import java.util.ArrayList;

public class Neuron {

    private static final int BIAS = 1;
    private static final double LEARNING_RATIO = 0.1;

    private ArrayList<Integer> inputs;
    private ArrayList<Double> weights;
    private double biasWeight;
    private double output;
    
    public Neuron(ArrayList<Double> weights, double biasWeight) {
    	this.inputs = new ArrayList<>();
        this.weights = weights;
        this.biasWeight = biasWeight;
    }

    public Neuron() {
        this.inputs = new ArrayList<>();
        this.weights = new ArrayList<>();
        this.biasWeight = Math.random();
    }

    public void setInputs(ArrayList<Integer> inputs) {
        if (this.inputs.size() == 0) {
        	this.inputs = new ArrayList<>(inputs);
            generateWeights();
        }
    	this.inputs = new ArrayList<>(inputs);
    }

    private void generateWeights() {
        for (int i = 0; i < inputs.size(); i++) {
            weights.add(Math.random());
        }
    }

    public void calculateOutput() {
        double sum = 0;

        for (int i = 0; i < inputs.size(); i++) {
            sum += inputs.get(i) * weights.get(i);
        }
        sum += BIAS * biasWeight;

        output = MathUtils.sigmoidValue(sum);
    }

    public void adjustWeights(double delta) {
        for (int i = 0; i < inputs.size(); i++) {
            double newWeight = weights.get(i);
            newWeight += LEARNING_RATIO * delta * inputs.get(i);
            weights.set(i, newWeight);
        }

        biasWeight += LEARNING_RATIO * delta * BIAS;
    }

    public double getOutput() {
        calculateOutput();

        return output;
    }
    
    public ArrayList<Double> getWeights() {
    	return weights;
    }
    
    public double getBiasWeight() {
    	return biasWeight;
    }

}
