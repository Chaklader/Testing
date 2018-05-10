package junittestcase;

import junit.framework.TestCase;


/*
JUnit provides a class known as TestCase. This class will help us to run all 
our test cases. In previous articles, we have used the @Test annotation on all 
our test cases. But, here we will not use any annotation and see how we can test 
the methods with the help of the TestCase class.

We will create "MyTestCase" class by extending the TestCase class and then proceed further 
for testing. Let’s start creating a project.
*/
public class MyTestCase extends TestCase {

	protected ListTest lstTest = new ListTest();

	protected void setUp() {
		lstTest.add("Apple");
		lstTest.add("Orange");
		lstTest.add("Grapes");
	}

	public void testSize() {
		assertEquals("Checking size of List", 3, lstTest.size());
	}

	public void testAdd() {
		lstTest.add("Banana");
		assertEquals("Adding 1 more fruit to list", 4, lstTest.size());
	}

	public void testRemove() {
		lstTest.remove("Orange");
		assertEquals("Removing 1 fruit from list", 2, lstTest.size());
	}

	protected void tearDown() {
		lstTest.removeAll();
	}
}
