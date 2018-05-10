

public class NumberOfAKindProvider {

    public static Object[] providePair() {

        return $(
                $(roll(1, 1, 1, 2, 3), hand(1, 1), score(2)),
                $(roll(2, 1, 1, 1, 1), hand(1, 1), score(2)),
                $(roll(2, 3, 4, 1, 1), hand(1, 1), score(2)),
                $(roll(2, 3, 5, 5, 5), hand(5, 5), score(10)),
                $(roll(2, 1, 5, 4, 3), null, score(0))
        );
    }

    public static Object[] provideThreeOfAKind() {

        return $(
                $(roll(1, 1, 1, 2, 3), hand(1, 1, 1), score(3)),
                $(roll(2, 1, 1, 1, 3), hand(1, 1, 1), score(3)),
                $(roll(2, 3, 1, 1, 1), hand(1, 1, 1), score(3)),
                $(roll(2, 3, 5, 5, 5), hand(5, 5, 5), score(15)),
                $(roll(2, 5, 5, 5, 6), hand(5, 5, 5), score(15)),
                $(roll(2, 2, 5, 5, 3), null, score(0))
        );
    }

    public static Object[] provideFourOfAKind() {

        return $(
                $(roll(1, 1, 1, 1, 3), hand(1, 1, 1, 1), score(4)),
                $(roll(2, 1, 1, 1, 1), hand(1, 1, 1, 1), score(4)),
                $(roll(2, 5, 5, 5, 5), hand(5, 5, 5, 5), score(20)),
                $(roll(2, 3, 4, 5, 5), null, score(0))
        );
    }

 

    public static Object[] provideFiveOfAKind() {

        return $(
                $(roll(1, 1, 1, 1, 1), hand(1, 1, 1, 1, 1), score(5)),
                $(roll(6, 6, 6, 6, 6), hand(6, 6, 6, 6, 6), score(30)),
                $(roll(6, 6, 6, 6), null, score(0)),
                $(roll(2, 3, 4, 6, 6), null, score(0))

        );
    }

    private static int[] hand(int... dice) {
        return dice;
    }

    private static int score(int score) {
        return score;
    }
}
