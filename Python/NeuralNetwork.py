from math import e, sin, log, atan
import time

class Utils:
	@staticmethod
	def timeit(function):
		start = time.time()
		function()

		return 'Process took ' + str(round(time.time() - start, 3)) + 's\nFinished with exit code 0' 

class InputNeuron:
	def __init__(self, value = 0):
		self.value = value

	def getValue(self) -> float:
		return self.value 

	def setValue(self, value: float) -> None:
		self.value = value

class Connection:
	def __init__(self, neuron, weight: float):
		self.neuron = neuron
		self.weight = weight

	def getValue(self) -> None:
		return self.neuron.getValue() * self.weight

class WorkingNeuron:
	def __init__(self):
		self.connections = []

	def addConnection(self, neuron, weight: float) -> None:
		self.connections.append( Connection(neuron, weight) )

	def _calculate(self) -> None:
		sum_ = 0

		for connection in self.connections:
			sum_ += connection.getValue()

		return sum_

	def getValue(self) -> float:
		return ActivationFunctions.Sigmoid( self._calculate() )

class NeuralNetwork:
	def __init__(self, input: InputNeuron, hidden: WorkingNeuron, output: WorkingNeuron):
		self.input = input
		self.hidden = hidden
		self.output = output

	def createFullMesh(self, weights):
		if len(weights[0]) != (len(self.input) * len(self.hidden)) or len(weights[1]) != (len(self.hidden) * len(self.output)):
			raise ValueError

		index = 0
		for input in self.input:
			for hidden in self.hidden:
				hidden.addConnection(input, weights[0][index])
				index += 1

		index = 0
		for hidden in self.hidden:
			for output in self.output:
				output.addConnection(hidden, weights[1][index])
				index += 1

	def getValue(self) -> list:
		return [i.getValue() for i in self.output]

class ActivationFunctions:
	@staticmethod
	def Identity(x):
		return x

	@staticmethod
	def RecitfiedLinear(x):
		return max(0, x)

	@staticmethod
	def Binary(x):
		if (x < 0):
			return 0
		return 1

	@staticmethod
	def Sigmoid(x):
		return 1 / (1 + e**(-x))

	@staticmethod
	def HyperbolicTangent(x):
		return (e**(2*x) - 1) / (e**(2*x) + 1)

	@staticmethod
	def ArcusTangens(x):
		return atan(x)

	@staticmethod
	def Softsign(x):
		return x / (1 + abs(x))

	@staticmethod
	def Gaussian(x):
		return e**(-x**(2))

	@staticmethod
	def Sinc(x):
		if (x == 0):
			return 1
		return sin(x) / x

	@staticmethod
	def Softplus(x):
		return log(1 + e**x)

if __name__ == '__main__':
	pass