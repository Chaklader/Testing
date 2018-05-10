package junitmultithread;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;

@RunWith(ConcurrentTestRunner.class)
public class CountCheckTest {

	private CountCheck counter = new CountCheck();
	
	@Before
	public void initialCount(){
		counter.initialize(2);
	}
	
	/*
		By default, the number of threads created by the library is 4.
		Hence, the final value of the count would be 2 + 4 = 6
	*/
	@Test
	public void addOne() {
		counter.addOne();
	}

	@After
	public void testCount() {
		assertEquals("Value should be 6", 6, counter.getCount());
	}
}
