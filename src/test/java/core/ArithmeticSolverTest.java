 package core;

 import junit.framework.testcase;
 
public class ArithmeticSolverTest extends TestCase {
	
	public void TestAdd(){
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(2, solver.add(2,2));
		
	}

	public void TestSubstract() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(4, solver.substract(4,2));
	}
	
	public void TestMultiply() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(8, solver.multiply(4,2));
	}
	
	public void TestDivide() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(3, solver.divide(9,3));
	}
	
	public void TestModulus() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(1, solver.moduls(5,2));
	}
}
