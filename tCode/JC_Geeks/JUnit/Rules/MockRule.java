

@RequiredArgsConstructor
public class MockRule implements TestRule{
	
	private final Object target;
	
	public Statement apply(Statement base, Description description) {
	    
	    return new Statement() {	      	
	      	@Override
			public void evaluate() throws Throwable {
				MockitoAnnotations.initMocks(target);
				base.evaluate();
			}
		}; 
	}

}