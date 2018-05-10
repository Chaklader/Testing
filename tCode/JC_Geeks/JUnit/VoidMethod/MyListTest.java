package junittestvoidmethod;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyListTest {

/*
The code marked @Before is executed before each test, while @BeforeClass 
runs once before the entire test fixture. If your test class has ten tests, 
@Before code will be executed ten times, but @BeforeClass will be executed 
only once.


In JUnit 5, the tags @BeforeEach and @BeforeAll are the equivalents of @Before 
and @BeforeClass in JUnit 4. Their names are a bit more indicative of when they 
run, loosely interpreted: 'before each tests' and 'once before all tests'.
*/

	private MyList lstTest = new MyList();

	/*
	@Before and @After runs before and after each test methods. 
	AS we have 4 tests, this will schema will run for 4 times.
	*/
	@Before
	public void init() {
		lstTest.add("Apple");
		lstTest.add("Orange");
		lstTest.add("Grapes");
	}

	@After
	public void destroy() {
		lstTest.removeAll();
	}

	@Test
	public void testSize() {
		assertEquals("Checking size of List", 3, lstTest.size());
	}

	@Test
	public void testAdd() {
		lstTest.add("Banana");
		assertEquals("Adding 1 more fruit to list", 4, lstTest.size());
	}

	@Test
	public void testRemove() {
		lstTest.remove("Orange");
		assertEquals("Removing 1 fruit from list", 2, lstTest.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveException() {
		lstTest.remove("Kiwi");
		assertEquals("Removing 1 fruit from list", 2, lstTest.size());
	}

}
