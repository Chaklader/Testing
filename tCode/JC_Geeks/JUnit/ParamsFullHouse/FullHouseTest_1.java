
@RunWith(JUnitParamsRunner.class)
public  class FullHouseTest {
	
	@Test
	@Parameters
	public void fullHouse(Collection rolled, int score) {
		assertThat(new FullHouse().getScore(rolled).getValue()).isEqualTo(score); 
	}

	private static int score(int score) {
		return score; 
	}

	/*
	* the test parameters for the full hourse 
	*/
	public Object[] parametersForFullHouse() { 	
		return $(
			$(roll(1, 1, 3, 3, 3), score(11)), 
			$(roll(2, 2, 2, 1, 1), score(8)), 
			$(roll(2, 3, 4, 1, 1), score(0)), 
			$(roll(5, 5, 5, 5, 5), score(25))
		); 
	}
}