package junitrunlistener;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class TestClassB {
	
	@Test
<<<<<<< HEAD
	public void testB1(){
=======
	public void test_B_1(){
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba
		assertTrue(true);
	}
	
	@Ignore
	@Test
<<<<<<< HEAD
	public void testB2(){
=======
	public void test_B_2(){
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba
		assertTrue(2==5);
	}
}
