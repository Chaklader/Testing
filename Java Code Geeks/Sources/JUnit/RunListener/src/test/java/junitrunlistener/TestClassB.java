package junitrunlistener;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class TestClassB {
	
	@Test
	public void testB1(){
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void testB2(){
		assertTrue(2==5);
	}
}
