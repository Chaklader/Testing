
/*
Parameterized unit tests are used to to test the same code under different 
conditions. Thanks to parameterized unit tests we can set up a test method 
that retrieves data from some data source. This data source can be a collection 
of test data objects, external file or maybe even a database. The general idea 
is to make it easy to test different conditions with the same unit test method, 
which will limit the source code we need to write and makes the test code more 
robust. We can call these tests data-driven unit tests.
*/
@RunWith(Parameterized.class)
public class FullHouseTest {

    private Collection rolled;
    private int score;

    public FullHouseTest(Collection rolled, int score) {
        this.rolled = rolled;
        this.score = score;
    }


    @Test
    public void fullHouse() {
        assertThat(new FullHouse().getScore(rolled).getValue()).isEqualTo(score);
    }

    @Parameterized.Parameters
    public static Iterable data() {

        return Arrays.asList(
                new Object[][]{
                        {roll(1, 1, 3, 3, 3), score(11)},
                        {roll(2, 2, 2, 1, 1), score(8)},
                        {roll(2, 3, 4, 1, 1), score(0)},
                        {roll(5, 5, 5, 5, 5), score(25)}
                }
        );
    }

    private static int score(int score) {
        return score;
    }
}
