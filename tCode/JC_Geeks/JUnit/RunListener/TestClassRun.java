package junitrunlistener;

import org.junit.runner.JUnitCore;

/*
	In JUnit RunListener Example, we shall show users how they can 
	add RunListener to the test cases. There are cases when we want 
	to respond to the events during a test case run. Here we can extend 
	the RunListener class and override the methods according to our 
	implementation. The JUnit RunListener can listen to the events of 
	the JUnit lifecycle.
*/

/*
	Output
	------

	Test cases to execute : 4
	Execution Started : test_A_1
	Execution Failure : java.lang.AssertionError
	Execution Finished : test_A_1

	Execution Started : test_A_2
	Execution Finished : test_A_2

	Execution Started : test_B_1
	Execution Finished : test_B_1

	Execution Ignored : test_B_2

	Test cases executed : 3
*/	
public class TestClassRun {

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new OurListener());
		runner.run(TestClassA.class, TestClassB.class);
	}
}
