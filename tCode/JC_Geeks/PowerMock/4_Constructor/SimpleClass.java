package com.javacodegeeks;

import java.util.Calendar;

public class SimpleClass {
	
	@SuppressWarnings("deprecation")
	public String getMeCurrentDateAsString() {
		
		return Calendar.getInstance().getTime().toGMTString();
	}
}
