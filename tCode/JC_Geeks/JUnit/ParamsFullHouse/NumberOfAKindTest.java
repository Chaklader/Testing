

@RunWith(JUnitParamsRunner.class)
public class NumberOfAKindTest {

    @Test
    @Parameters(source = NumberOfAKindProvider.class, method = "providePair")
    public void pair(Collection rolled, int[] expected, int score) {

        NumberOfAKind sut = new NumberOfAKind(2);
        doTest(rolled, expected, score, sut);
    }


    @Test
    @Parameters(source = NumberOfAKindProvider.class, method = "provideThreeOfAKind")
    public void threeOfAKind(Collection rolled, int[] expected, int score) {

        NumberOfAKind sut = new NumberOfAKind(3);
        doTest(rolled, expected, score, sut);
    }
 
    @Test
    @Parameters(source = NumberOfAKindProvider.class, method = "provideFourOfAKind")
    public void fourOfAKind(Collection rolled, int[] expected, int score) {
        NumberOfAKind sut = new NumberOfAKind(4);
        doTest(rolled, expected, score, sut);
    }
 
    @Test
    @Parameters(source = NumberOfAKindProvider.class, method = "provideFiveOfAKind")
    public void fiveOfAKind(Collection rolled, int[] expected, int score) {
        NumberOfAKind sut = new NumberOfAKind(5);
        doTest(rolled, expected, score, sut);
    }
 
    private void doTest(Collection rolled, int[] expected, int score, NumberOfAKind sut) {
        Collection consecutiveDice = sut.getConsecutiveDice(rolled);
        assertDiceContainsValues(consecutiveDice, expected);
        assertThat(sut.getScore(rolled).getValue()).isEqualTo(score);
    }
 
    private void assertDiceContainsValues(Collection dice, int[] expected) {
        Collection values = toInts(dice);
        if (expected == null) {
            assertThat(values).isEmpty();
            return;
        }
        for (int i = 0; i < expected.length; i++) {
            assertThat(values).hasSize(expected.length).contains(expected[i]);
        }
    }
 
    private Collection toInts(Collection dice) {
        return Collections2.transform(dice, new Function() {
            @Override
            public Integer apply(Dice input) {
                return input.getValue();

            }
        });
    }
}
