

@RunWith(Parameterized.class)
public  class FizzBuzzTest{
	
	public Object[] parametersForFizzBuzz() { 
		return $(
            $(1, "1"),
            $(2, "2"),
            $(3, "Fizz"),
            $(4, "4"),
            $(5, "Buzz"),
            $(6, "Fizz"),
            $(7, "7"),
            $(10, "Buzz"),
            $(15, "FizzBuzz"),
            $(30, "FizzBuzz")
		); 
	}

	@Test
	@Parameters({"1", "2", "4", "7", "11", "13", "14"})
	public void returnsNumberForNumberNotDivisibleByThreeAndFive(int number){
	    assertThat(fizzBuzz.calculate(number)).isEqualTo("" + number); 
	}

	@Test
	@Parameters({"3", "6", "9", "12", "18", "21", "24"}) 
	public void returnFizzForNumberDivisibleByThree(int number){
	    assertThat(fizzBuzz.calculate(number)).isEqualTo("Fizz")
	}

	@Test
	@Parameters({"5", "10", "20", "25", "35", "40", "50"}) 
	public void returnBuzzForNumberDivisibleByFive(int number) {
	    assertThat(fizzBuzz.calculate(number)).isEqualTo("Buzz")
	}

	@Test
	@Parameters({"15", "30", "45", "60"})
	public void returnsFizzBuzzForNumberDivisibleByThreeAndFive(int number){
	    assertThat(fizzBuzz.calculate(number)).isEqualTo("FizzBuzz");
	}

	@Test
	@Parameters
	public void fizzBuzz(int given, String expected) {
	    assertThat(fizzBuzz.calculate(given)).isEqualTo(expected
	}
}