package neuralnetwork.activationfunctions;

public class Sigmoid implements ActivationFunction {

	@Override
	public double activation(double x) {
		
		return 1 / (1 + Math.pow(Math.E, x)); 
	}

}
