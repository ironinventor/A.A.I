package com.AceAIcom.AceAI;

import java.util.ArrayList;

public class TrainingSet {

	// The inputs for netwwork 
    private ArrayList<Integer> inputs;
    
    // The outputs that is desired.
    private ArrayList<Double> goodOutput;

    public TrainingSet(ArrayList<Integer> inputs, ArrayList<Double> goodOutput) {
        this.inputs = inputs;
        this.goodOutput = goodOutput;
    }

    public ArrayList<Integer> getInputs() {
        return inputs;
    }

    public ArrayList<Double> getGoodOutput() {
        return goodOutput;
    }
}
