package neuralnetwork;

import java.util.ArrayList;
import java.util.List;

import neuralnetwork.activationfunctions.ActivationFunction;
import neuralnetwork.activationfunctions.Sigmoid;

public class WorkingNeuron extends Neuron {

	private List<Connection> connections = new ArrayList<Connection>();
	private ActivationFunction activationFunction = new Sigmoid();
	
	@Override
	public float getValue() {
		float sum = 0;
		
		for(Connection c: connections) {
			sum += c.getValue();
		}
		
		return (float)activationFunction.activation(sum);
	}
	
	public void addConnection(Connection c) {
		connections.add(c);
	}
	
}