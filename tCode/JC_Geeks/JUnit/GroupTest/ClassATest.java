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
	
	public void classA_Test1() {
		System.out.println("classA_Test1");
	}

	@Test
	public void classA_Test2() {
		System.out.println("classA_Test2");
	}
}
