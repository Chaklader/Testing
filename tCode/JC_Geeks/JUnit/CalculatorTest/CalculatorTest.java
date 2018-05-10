package junittestconstructor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CalculatorTest {

	private Calculator c;
	
	@Test
	public void constructorTest(){
		c = new Calculator(4, 5);
		assertThat(9, is(c.sum()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorExceptionTest(){
		c = new Calculator(-4, 5);
	}
	
}
