package junitgrouptest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SlowTests.class)
public class ClassCTest {

	@Test
	public void classCTest1() {
		System.out.println("classCTest1");
	}

	@Test
	public void classCTest2() {
		System.out.println("classCTest2");
	}
}
