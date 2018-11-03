package neuralnetwork;

public class Connection {

	private Neuron neuron;
	private float weight;
	
	public Connection(Neuron neuron, float weight) {
		this.neuron = neuron;
		this.weight = weight;
	}

	public float getValue() {
		return this.neuron.getValue() * this.weight;
	}
	
}