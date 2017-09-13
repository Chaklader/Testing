package junitgrouptest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SlowTests.class)
public class ClassCTest {

	@Test
<<<<<<< HEAD
	public void classCTest1() {
		System.out.println("classCTest1");
	}

	@Test
	public void classCTest2() {
		System.out.println("classCTest2");
=======
	public void classC_Test1() {
		System.out.println("classC_Test1");
	}

	@Test
	public void classC_Test2() {
		System.out.println("classC_Test2");
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba
	}
}
