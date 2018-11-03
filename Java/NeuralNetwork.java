package neuralnetwork;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
	
	private List<InputNeuron> inputneurons = new ArrayList<InputNeuron>();
	private List<WorkingNeuron> hiddenneurons = new ArrayList<WorkingNeuron>(); 
	private List<WorkingNeuron> outputneurons = new ArrayList<WorkingNeuron>();
	
	public WorkingNeuron createNewOutput() {
		WorkingNeuron wn = new WorkingNeuron();
		outputneurons.add(wn);
		
		return wn;
	}
	
	public void createHiddenNeurons(int amount) {
		for (int i = 0; i < amount; i++) {
			hiddenneurons.add(new WorkingNeuron());
		}
	}
	
	public InputNeuron createNewInput() {
		InputNeuron in = new InputNeuron();
		inputneurons.add(in);
		
		return in;
	}
	
	public void createFullMesh() {
		if (hiddenneurons.size() == 0) {
			for(WorkingNeuron wn: outputneurons) {
				for(InputNeuron in: inputneurons) {
					wn.addConnection(new Connection(in, 0));
				}
			}
		} else {
			for(WorkingNeuron wn: outputneurons) {
				for(WorkingNeuron hidden: hiddenneurons) {
					wn.addConnection(new Connection(hidden, 0));
				}
			}
			
			for(WorkingNeuron hidden: hiddenneurons) {
				for(InputNeuron in: inputneurons) {
					hidden.addConnection(new Connection(in, 0));
				}
			}
		}
		
	}
	
	public void createFullMesh(float... weights) {
		if (hiddenneurons.size() == 0) {
			if(weights.length != inputneurons.size() * outputneurons.size()) {
				throw new RuntimeException();
			}
			
			int index = 0;
			
			for(WorkingNeuron wn: outputneurons) {
				for(InputNeuron in: inputneurons) {
					wn.addConnection(new Connection(in, weights[index++]));
				}
			}
		} else {
			if (weights.length != inputneurons.size() * hiddenneurons.size() + hiddenneurons.size() * outputneurons.size()) {
				throw new RuntimeException();
			}
			
			int index = 0;
			
			for(WorkingNeuron hidden: hiddenneurons) {
				for(InputNeuron in: inputneurons) {
					hidden.addConnection(new Connection(in, weights[index++]));
				}
			}
			
			for(WorkingNeuron out: outputneurons) {
				for(WorkingNeuron hidden: hiddenneurons) {
					out.addConnection(new Connection(hidden, weights[index++]));
				}
			}
		}
		
	}
	
}