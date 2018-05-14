
/*
As in card poker, a Full House is a roll where you have both a 3 of a kind, 
and a pair. For the sake of simplicity, the score is a sum of all dice in a 
roll.
*/
class FullHouse implements Scoreable {

    @Override
    public Score getScore(Collection dice) {

        Score pairScore = Scorables.pair().getScore(dice);
        Score threeOfAKindScore = Scorables.threeOfAKind().getScore(pairScore.getReminder());

        if (bothAreGreaterThanZero(pairScore.getValue(), threeOfAKindScore.getValue())) {
            return new Score(pairScore.getValue() 
            		+ threeOfAKindScore.getValue()); // no reminder
        }

        return new Score(0, dice);
    }

    private boolean bothAreGreaterThanZero(int value1, int value2) {
        return value1 > 0 && value2 > 0;
    }
}
