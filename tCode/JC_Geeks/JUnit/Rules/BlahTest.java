

public  class BlahTest{
	
	@Rule
	public MockRule mock = new MockRule(this);
	
	@Mock
	private BlahService service;

	public void testBlah() throws Exception {
        Assert.assertThat(service.blah(),CoreMatchers.notNullValue());
    }
}