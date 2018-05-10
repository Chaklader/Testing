package junitmultithread;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;


/*
	Concurrent-junit library helps the users to test the methods for multi-threading. 
	It will create threads for testing methods. By default, number of threads created 
	by this library is 4, but we can set the desired number of threads. This can be 
	achieved by @ThreadCount annotation of concurrent-junit. We will see the use of 
	@ThreadCount annotation later in the example.
*/
@RunWith(ConcurrentTestRunner.class)
public class CountCheckThreadCountTest {

	private CountCheck counter = new CountCheck();

	private final static int THREADCOUNT = 5;

	@Before
	public void initialCount() {
		counter.initialize(2);
	}

	@Test
	@ThreadCount(THREAD_COUNT)
	public void addOne() {
		counter.addOne();
	}

	@After
	public void testCount() {
		assertEquals("Value should be 7", 7, counter.getCount());
	}
	
}
