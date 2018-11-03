package neuralnetwork.activationfunctions;

public class HyperbolicTangent implements ActivationFunction {

	@Override
	public double activation(double x) {
		
		double numerator = Math.pow(Math.E, 2*x) - 1;
		double denominator = Math.pow(Math.E, 2*x) + 1;
		
		return numerator / denominator;
	}

}
