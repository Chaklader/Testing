package com.javacodegeeks.hughwphamill.mockito.verification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;




@RunWith(MockitoJUnitRunner.class)
public class PrinterDiagnosticsTest {
	
	private PrinterDiagnostics diagnostics;

	@Mock
	private Printer printer;

	@Captor
	private ArgumentCaptor<String> textCaptor;

	@Before
	public void setUp() throws Exception {
		diagnostics = new PrinterDiagnostics(printer);
	}
	
	@Test
	public void verifydiagnosticinformationaddedtotext() {

		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

		Integer copies = 3;
		Boolean collate = true;
		String expectedCopies = "Copies: " + copies;
		String expectedCollate = "Collate: " + collate;
		
		// When
		diagnostics.diagnosticPrint(text, copies, collate);
		
		// Then
		verify(printer).print(textCaptor.capture(), eq(copies), eq(collate));

		assertTrue(textCaptor.getValue().contains(expectedCopies));
		assertTrue(textCaptor.getValue().contains(expectedCollate));
		assertTrue(textCaptor.getValue().contains(text));	
	}
	
	@Test
	public void verifydiagnosticinformationaddedtotextandoriginalprint() {

		// Given
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

		Integer copies = 3;
		Boolean collate = true;
		String expectedCopies = "Copies: " + copies;
		String expectedCollate = "Collate: " + collate;
		
		// When
		diagnostics.diagnosticAndOriginalPrint(text, copies, collate);
		
		// Then
		verify(printer, times(2)).print(textCaptor.capture(), eq(copies), eq(collate));
		
		List<String> texts = textCaptor.getAllValues();
		assertEquals(2, texts.size());
		
		
		// First captured text is Diagnostic Print
		assertTrue(texts.get(0).contains(expectedCopies));
		assertTrue(texts.get(0).contains(expectedCollate));
		assertTrue(texts.get(0).contains(text));
		
		// Second captured text is normal Print
		assertFalse(texts.get(1).contains(expectedCopies));
		assertFalse(texts.get(1).contains(expectedCollate));
		assertEquals(text, texts.get(1));
	}
}
