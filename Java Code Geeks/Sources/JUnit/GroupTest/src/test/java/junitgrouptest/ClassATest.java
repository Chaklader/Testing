package junitgrouptest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassATest {

	@Test
	@Category(PerformanceTests.class)
	public void classATest1() {
		System.out.println("classATest1");
	}

	@Test
	public void classATest2() {
		System.out.println("classATest2");
	}

}
