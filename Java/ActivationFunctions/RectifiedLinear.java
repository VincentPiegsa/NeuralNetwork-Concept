package neuralnetwork.activationfunctions;

public class RectifiedLinear implements ActivationFunction {

	@Override
	public double activation(double x) {
		return Math.max(0, x);
	}

}
