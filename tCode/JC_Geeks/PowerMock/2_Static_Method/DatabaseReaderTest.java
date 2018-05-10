package com.javacodegeeks.powermock.staticmethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(DatabaseReader.class)
public class DatabaseReaderTest {
	
	
	@Test
	public void testGetById() {

		int inputId = 1;
		String returnValue = "JavaCodeGeeks";

		mockStatic(DatabaseReader.class);

		try {

			when(DatabaseReader.getById(inputId))
				.thenReturn(returnValue);

			String actual = DatabaseReader.getById(inputId);
			
			verifyStatic();
			assertEquals(returnValue, actual);
		} catch (SQLException e) {
			fail("No exception should be thrown.");
		}
	}
	
	@Test
	public void testGetByIdMockDatabase() {

		String query = "SELECT * FROM Foo WHERE Id = ?";
		int inputId = 1;
		String returnValue = "JavaCodeGeeks";
		
		Connection connectionMock = Mockito.mock(Connection.class);
		PreparedStatement preparedStatementMock = Mockito.mock(PreparedStatement.class);
		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
		
		mockStatic(DriverManager.class);

		try {

			when(DriverManager.getConnection(DatabaseReader.CONNECTION))
			    .thenReturn(connectionMock);

			when(connectionMock.prepareStatement(query))
				.thenReturn(preparedStatementMock);
			
			when(preparedStatementMock.executeQuery())
				.thenReturn(resultSetMock);

			when(resultSetMock.next())
				.thenReturn(true);
			
			when(resultSetMock.getString(0))
				.thenReturn(returnValue);
			
			String actual = DatabaseReader.getById(inputId);
			
			verify(connectionMock).prepareStatement(query);
			verify(preparedStatementMock).executeQuery();
			verify(resultSetMock).next();
			verify(resultSetMock).getString(0);
			verifyStatic();

			assertEquals(returnValue, actual);
		} catch (SQLException e) {
			fail("No exception should be thrown.");
		}
	}
}
