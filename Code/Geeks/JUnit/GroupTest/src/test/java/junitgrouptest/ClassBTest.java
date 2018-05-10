package junitgrouptest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassBTest {

	@Test
	@Category(PerformanceTests.class)
<<<<<<< HEAD
	public void classBTest1() {
		System.out.println("classBTest1");
=======
	public void classB_Test1() {
		System.out.println("classB_Test1");
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba
	}

	@Test
	@Category(SlowTests.class)
<<<<<<< HEAD
	public void classBTest2() {
		System.out.println("classBTest2");
=======
	public void classB_Test2() {
		System.out.println("classB_Test2");
>>>>>>> c709250ca684c5f395f29796d3b7d8d605f163ba
	}
}
