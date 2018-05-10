package junitwebapp;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

/*
We can also test the web applications with the help of JUnit. There are numerous 
frameworks available which in collaboration with JUnit helps in testing. You can 
use any one of them to test your web applications. Some of them are:

JWebUnit
HttpUnit
Selenium

In this example we will stick to the JWebUnit.

JWebUnit is a Java based testing framework for web applications. JWebUnit provides a 
high-level Java API for navigating a web application combined with a set of assertions 
to verify the application’s correctness. This includes navigation via links, form 
entry and submission, validation of table contents, and other typical business web 
application features.

JWebUnit uses the HTMLUNIT or WEBDRIVER as the testing engine to test the web 
application. You can assert any type of web element, may be a Form, Link, button 
or a table. For the simplicity perspective, we have only taken an example of the 
link element of the web. All other scenarios will work as same.
*/
public class JWebUnitTest {
	@Before
	public void prepare() {
		setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
		setBaseUrl("http://localhost:8081/junitwebapp");
	}

	@Test
	public void testLoginPage() {
		beginAt("index.jsp"); 
		assertTitleEquals("Login");
		assertLinkPresent("home");
		clickLink("home");
		assertTitleEquals("Home");
	}
	
	@Test
	public void testHomePage() {
		beginAt("home.jsp"); 
		assertTitleEquals("Home");
		assertLinkPresent("login");
		clickLink("login");
		assertTitleEquals("Login");
	}
}