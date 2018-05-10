package com.javacodegeeks;

import java.util.Date;

public class PowerMockSpyExample {
	
	public String getCurrentDateAsString() {
		return new Date().toGMTString();
	}
}
