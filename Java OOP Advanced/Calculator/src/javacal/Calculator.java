package javacal;


public class Calculator {

	
		// TODO Auto-generated method stub
		public double OperandOne;
		public double OperandTwo;
		public String Operation;
		public static double Results;
	


		public Calculator(double operandOne2, double operandTwo2, String operation2) {
			this.OperandOne=operandOne2;
			this.OperandTwo=operandTwo2;
			this.Operation=operation2;
		}


		public double getOperandOne() {
			return OperandOne;
		}

		public void setOperandOne(double operandOne) {
			OperandOne = operandOne;
		}

		public double getOperandTwo() {
			return OperandTwo;
		}

		public void setOperandTwo(double operandTwo) {
			OperandTwo = operandTwo;
		}

		public String getOperation() {
			return Operation;
		}

		public void setOperation(String operation) {
			Operation = operation;
		}
		
		public void performOperation() {
			if (Operation=="+") {
				Results=getOperandOne() + getOperandTwo();
			}
			if (Operation=="-") {
				Results=getOperandOne() - getOperandTwo();
			}
			if (Operation=="*") {
				Results=getOperandOne() * getOperandTwo();
			}
			if (Operation=="/") {
				Results=getOperandOne() / getOperandTwo();
			}
	
		}

		double getResults() {

			return Results;
		}
}