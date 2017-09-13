package com.javacodegeeks;

public class PowerMockConstructorExample {
	
	public String getMeSimpleObject() {
		SimpleClass simpleClass = new SimpleClass();
		
		String returnValue = simpleClass.getMeCurrentDateAsString();
		return returnValue;
	}
}
