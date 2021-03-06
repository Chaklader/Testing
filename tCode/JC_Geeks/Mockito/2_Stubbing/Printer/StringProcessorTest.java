package com.javacodegeeks.hughwphamill.mockito.stubbing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.javacodegeeks.hughwphamill.mockito.stubbing.Printer;
import com.javacodegeeks.hughwphamill.mockito.stubbing.StringProcessor;




@RunWith(MockitoJUnitRunner.class)
public class StringProcessorTest {

	@Mock
	private Printer printer;

	@Spy
	private SysoutPrinter sysoutPrinter;
	
	@Test
	public void internal_buffer_should_be_absent_after_construction() throws Exception {

		StringProcessor processor = new StringProcessor(printer);
		Optional<String> actualBuffer = processor.statusAndTest();
		
		assertFalse(actualBuffer.isPresent());
	}
	
	@Test
	public void internalbuffershouldbeabsentafterconstructionsysout() throws Exception {

		// Given
		StringProcessor processor = new StringProcessor(sysoutPrinter);
		
		// When
		Optional<String> actualBuffer = processor.statusAndTest();
		
		// Then, it will actually print buffer which is 
		// undesiarable due to beaocme a spy 
		assertFalse(actualBuffer.isPresent());
	}
	
	@Test
	public void internalbuffershouldbeabsentafterconstructionsysoutwithdonothing() throws Exception {
		
		StringProcessor processor = new StringProcessor(sysoutPrinter);
		doNothing().when(sysoutPrinter).printTestPage();
		
		Optional<String> actualBuffer = processor.statusAndTest();
		
		assertFalse(actualBuffer.isPresent());
	}

	
	@Test(expected = PrinterNotConnectedException.class)
	public void printernotconnectedexceptionshouldbethrownupthestack() throws Exception {

		// Given
		StringProcessor processor = new StringProcessor(printer);
		doThrow(new PrinterNotConnectedException()).when(printer).printTestPage();
		
		// When
		Optional<String> actualBuffer = processor.statusAndTest();
		
		// Then
		assertFalse(actualBuffer.isPresent());
	}

}





