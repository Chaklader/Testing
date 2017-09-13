package junitrunlistener;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestClassA {

	@Test
	public void testA1(){
		assertTrue(1==2);
	}
	
	@Test
	public void testA2(){
		assertTrue(true);
	}
}
