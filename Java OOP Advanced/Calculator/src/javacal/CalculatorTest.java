package javacal;

public class CalculatorTest {

	
	public static void main(String[] args) {
		Calculator problem = new Calculator(80.00,8.00,"/");
//		problem.setOperandOne(3);
//		problem.setOperandTwo(7);
//		problem.setOperation("+");
		problem.performOperation();
		System.out.println(problem.getResults());
		
		
		
}

	

	
	
}
