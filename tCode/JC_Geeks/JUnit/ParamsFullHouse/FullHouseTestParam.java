

@RunWith(JUnitParamsRunner.class)
public class FullHouseTestParams {

    @Test
    @Parameters
    public void fullHouse(Collection rolled, int score) {
        assertThat(new FullHouse().getScore(rolled).getValue()).isEqualTo(score);
    }

    public Object[] parametersForFullHouse() {

        return $(
                $(roll(1, 1, 3, 3, 3), score(11)),
                $(roll(2, 2, 2, 1, 1), score(8)),
                $(roll(2, 3, 4, 1, 1), score(0)),
                $(roll(5, 5, 5, 5, 5), score(25))
        );
    }

    private static int score(int score) {
        return score;
    }
}
