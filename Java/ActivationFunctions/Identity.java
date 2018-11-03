package neuralnetwork.activationfunctions;

public class Identity implements ActivationFunction {

	@Override
	public double activation(double x) {
		return x;
	}

}
