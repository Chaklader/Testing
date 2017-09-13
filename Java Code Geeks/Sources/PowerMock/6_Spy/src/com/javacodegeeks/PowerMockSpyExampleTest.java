package com.javacodegeeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerMockSpyExample.class)
public class PowerMockSpyExampleTest {
	
	@Test
	public void testGetCurrentDateAsString() {

		PowerMockSpyExample spy = PowerMockito.spy(new PowerMockSpyExample());
		
		Mockito.when(spy.getCurrentDateAsString()).thenReturn("Test Date");
		String actual = spy.getCurrentDateAsString();
		Assert.assertEquals("Test Date", actual);
		Mockito.verify(spy, Mockito.times(1)).getCurrentDateAsString();
	}

}
