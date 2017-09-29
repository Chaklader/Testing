package junitmultithread;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;

@RunWith(ConcurrentTestRunner.class)
public class CountCheckThreadCountTest {

	private CountCheck counter = new CountCheck();
<<<<<<< HEAD
	private final static int THREADCOUNT = 5;
=======
	private final static int THREAD_COUNT = 5;
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba

	@Before
	public void initialCount() {
		counter.initialize(2);
	}

	@Test
<<<<<<< HEAD
	@ThreadCount(THREADCOUNT)
=======
	@ThreadCount(THREAD_COUNT)
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba
	public void addOne() {
		counter.addOne();
	}

	@After
	public void testCount() {
		assertEquals("Value should be 7", 7, counter.getCount());
	}
}
