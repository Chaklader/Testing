package com.javacodegeeks.hughwphamill.mockito.verification;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static com.javacodegeeks.hughwphamill.mockito.verification.First.first;

@RunWith(MockitoJUnitRunner.class)
public class PrinterTest {

	@Mock
	private Printer printer;
	@Mock
	private List<String> list;

	@Test
	public void simple_interaction_verification() {
		// Given
		
		// When
		printer.printTestPage();
		
		// Then
		verify(printer).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_times_1() {
		// Given
		
		// When
		printer.printTestPage();
		
		// Then
		verify(printer, times(1)).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_times_3() {
		// Given
		
		// When
		printer.printTestPage();
		printer.printTestPage();
		printer.printTestPage();
		
		// Then
		verify(printer, times(3)).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_atleastonce() {
		// Given
		
		// When
		printer.printTestPage();
		printer.printTestPage();
		
		// Then
		verify(printer, atLeastOnce()).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_atleast_2() {
		// Given
		
		// When
		printer.printTestPage();
		printer.printTestPage();
		printer.printTestPage();
		
		// Then
		verify(printer, atLeast(2)).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_atmost_3() {
		// Given
		
		// When
		printer.printTestPage();
		printer.printTestPage();
		
		// Then
		verify(printer, atMost(3)).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_never() {
		// Given
		
		// When
		
		// Then
		verify(printer, never()).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_only() {
		// Given
		
		// When
		printer.printTestPage();
	
		// Then
		verify(printer, only()).printTestPage();		
	}
	
	@Ignore
	@Test
	public void simple_interaction_verification_only_fails() {
		// Given
		
		// When
		printer.printTestPage();
		printer.turnOff();
		
		// Then
		verify(printer, only()).printTestPage();		
	}
	
	@Test
	public void simple_interaction_verification_first() {
		// Given
		
		// When
		printer.printTestPage();
		printer.turnOff();		
				
		// Then
		verify(printer, first()).printTestPage();		
	}
	
	@Ignore
	@Test
	public void simple_interaction_verification_first_fails() {
		// Given
		
		// When
		printer.turnOff();
		printer.printTestPage();				
				
		// Then
		verify(printer, first()).printTestPage();		
	}
	
	@Test
	public void verification_with_actual_parameters() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		Integer copies = 3;
		Boolean collate = true;
		
		// When
		printer.print(text, copies, collate);
				
		// Then
		verify(printer).print(text, copies, collate);		
	}
	
	@Test
	public void verification_with_actual_parameters_and_verification_mode() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String text2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco " 
				+ "laboris nisi ut aliquip ex ea commodo consequat.";
		Integer copies = 3;
		Boolean collate = true;
		
		// When
		printer.print(text, copies, collate);
				
		// Then
		verify(printer, never()).print(text2, copies, collate);		
	}
	
	@Test
	public void multiple_verification_with_actual_parameters() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String text2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco " 
				+ "laboris nisi ut aliquip ex ea commodo consequat.";
		Integer copies = 3;
		Boolean collate = true;
		
		// When
		printer.print(text, copies, collate);
		printer.print(text2, copies, collate);
				
		// Then
		verify(printer).print(text, copies, collate);
		verify(printer).print(text2, copies, collate);		
	}
	
	@Ignore
	@Test
	public void verification_with_actual_parameters_fails() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String text2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco " 
				+ "laboris nisi ut aliquip ex ea commodo consequat.";
		Integer copies = 3;
		Boolean collate = true;
		
		// When
		printer.print(text2, copies, collate);
				
		// Then
		verify(printer).print(text, copies, collate);		
	}
	
	@Test
	public void verification_with_matchers() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String text2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco " 
				+ "laboris nisi ut aliquip ex ea commodo consequat.";
		Integer copies3 = 3;
		Integer copies4 = 4;
		Boolean doCollate = true;
		Boolean doNotCollate = false;
		
		// When
		printer.print(text, copies3, doCollate);
		printer.print(text2, copies4, doNotCollate);
				
		// Then
		verify(printer, times(2)).print(anyString(), anyInt(), anyBoolean());		
	}
	
	@Test
	public void verification_with_mixed_matchers() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String text2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco " 
				+ "laboris nisi ut aliquip ex ea commodo consequat.";
		Integer copies = 5;
		Boolean collate = true;
		
		// When
		printer.print(text, copies, collate);
		printer.print(text2, copies, collate);
				
		// Then
		verify(printer, times(2)).print(anyString(), eq(copies), eq(collate));		
	}
	
	@Ignore
	@Test
	public void verification_with_mixed_matchers_fails() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		Integer copies5 = 5;
		Integer copies10 = 10;
		Boolean collate = true;
		
		// When
		printer.print(text, copies10, collate);
				
		// Then
		verify(printer).print(anyString(), eq(copies5), eq(collate));		
	}
	
	@Test
	public void verification_with_timeout() {
		// Given
		
		// When
		Executors.newFixedThreadPool(1).execute(() -> printer.printTestPage());
				
		// Then
		verify(printer, timeout(100)).printTestPage();
	}
	
	@Ignore
	@Test
	public void verification_with_timeout_fails() throws InterruptedException {
		// Given
		
		// When
		Executors.newFixedThreadPool(1).execute(this::printTestWithSleep);
				
		// Then
		verify(printer, timeout(100)).printTestPage();
	}
	
	private void printTestWithSleep() {
		try {
			Thread.sleep(200L);
			printer.printTestPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void verification_with_timeout_with_verification_mode() {
		// Given
		int poolsize = 5;
		
		// When
		ExecutorService service = Executors.newFixedThreadPool(poolsize);
		service.execute(this::printTestWithSleep);
		service.execute(this::printTestWithSleep);
		service.execute(this::printTestWithSleep);
				
		// Then
		verify(printer, timeout(500).times(3)).printTestPage();
	}
	
	@Ignore
	@Test
	public void verification_with_timeout_with_verification_mode_fails() {
		// Given
		int poolsize = 1;
		
		// When
		ExecutorService service = Executors.newFixedThreadPool(poolsize);
		service.execute(this::printTestWithSleep);
		service.execute(this::printTestWithSleep);
		service.execute(this::printTestWithSleep);
				
		// Then
		verify(printer, timeout(500).times(3)).printTestPage();
	}
	
	@Test
	public void verify_zero_interactions() {
		// Given
		
		// When
				
		// Then
		verifyZeroInteractions(printer, list);		
	}
	
	@Ignore
	@Test
	public void verify_zero_interactions_fails() {
		// Given
		
		// When
		printer.printTestPage();
				
		// Then
		verifyZeroInteractions(printer, list);		
	}
	
	@Test
	public void verify_no_more_interactions() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		Integer copies = 3;
		Boolean collate = true;
		
		// When
		printer.print(text, copies, collate);
				
		// Then
		verify(printer).print(text, copies, collate);
		verifyNoMoreInteractions(printer);
	}
	
	@Ignore
	@Test
	public void verify_no_more_interactions_fails() {
		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		Integer copies = 3;
		Boolean collate = true;
		
		// When
		printer.print(text, copies, collate);
		printer.turnOff();
				
		// Then
		verify(printer).print(text, copies, collate);
		verifyNoMoreInteractions(printer);
	}
	
	@Test
	public void verify_in_order() {
		// Given
		InOrder inOrder = Mockito.inOrder(printer);
		
		// When
		printer.printTestPage();
		printer.turnOff();
				
		// Then
		inOrder.verify(printer).printTestPage();
		inOrder.verify(printer).turnOff();
	}
	
	@Ignore
	@Test
	public void verify_in_order_fails() {
		// Given
		InOrder inOrder = Mockito.inOrder(printer);
		
		// When
		printer.turnOff();
		printer.printTestPage();
				
		// Then
		inOrder.verify(printer).printTestPage();
		inOrder.verify(printer).turnOff();
	}
	
	@Test
	public void verify_in_order_multiple() {
		// Given
		InOrder inOrder = Mockito.inOrder(printer, list);
		
		// When
		printer.printTestPage();
		list.clear();
		printer.turnOff();
				
		// Then
		inOrder.verify(printer).printTestPage();
		inOrder.verify(list).clear();
		inOrder.verify(printer).turnOff();
	}
}
