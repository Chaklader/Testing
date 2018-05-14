

/*
* @ClassRule your rule instance should be static just 
* like the @BeforeClass and @AfterClass methods. 
*/
public  class BlahServerTest{

	
	@ClassRule
	public static MyServer server = new MyServer();

	@Test
	public void testBlah() throws Exception {
		// test something that depends on the server.
	}
}


