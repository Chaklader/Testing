package com.javacodegeeks.hughwphamill.mockito.stubbing;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ImageProcessorTest {

	
	private ImageProcessor processor;
	
	@Spy
	private BufferedImage imageSpy = new BufferedImage(200, 200, BufferedImage.TYPEINTARGB);
	@Mock
	Image mockThumbnail;
	
	@Before
	public void setup() {
		processor = new ImageProcessor(imageSpy);	
	}
	
	@Test
	public void scaleshouldreturninternalimagescaled() throws Exception {
		// Given
		given(imageSpy.getScaledInstance(-1, 100, Image.SCALEFAST)).willReturn(mockThumbnail);
		
		// When
		Image actualImage = processor.overwriteImageWithStripesAndReturnThumbnail(100);
		
		// Then
		assertEquals(actualImage, mockThumbnail);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwsexception() throws Exception {
		// Given
		given(imageSpy.getScaledInstance(anyInt(), anyInt(), anyInt())).willReturn(mockThumbnail);
		
		// Immediate IllegalArgumentException
	}
	
	@Test
	public void scaleshouldreturninternalimagescaleddoReturn() throws Exception {
		// Given
		doReturn(mockThumbnail).when(imageSpy).getScaledInstance(anyInt(), anyInt(), anyInt());
		
		// When
		Image actualImage = processor.overwriteImageWithStripesAndReturnThumbnail(100);
		
		// Then
		assertEquals(actualImage, mockThumbnail);
	}
	
	@Test
	public void scaleshouldreturninternalimagescaleddoReturndoCallRealMethod() throws Exception {
		// Given
		doReturn(mockThumbnail).doCallRealMethod().when(imageSpy).getScaledInstance(anyInt(), anyInt(), anyInt());
		
		// When
		Image actualImage = processor.overwriteImageWithStripesAndReturnThumbnail(100);
		
		// Then
		assertEquals(actualImage, mockThumbnail);
	}
}
