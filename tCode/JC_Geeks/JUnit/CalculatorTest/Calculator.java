package junittestconstructor;

public class Calculator {

	private int numA;
	private int numB;
	
	Calculator(int numA,int numB){
		this.numA = numA;
		this.numB = numB;
		if(numA<0 || numB<0){
			throw new IllegalArgumentException();
		}
	}
	
	public int sum(){
		return this.numA + this.numB;
	}
}
