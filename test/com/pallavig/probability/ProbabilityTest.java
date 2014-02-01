package com.pallavig.probability;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ProbabilityTest {
    @Test
    public void testGetProbability() {
        Probability heads = new Probability(0.5);

        assertEquals(0.5, heads.value());
    }

    @Test
    public void testGettingTheProbabilityOfAnEventNoHappening() {
        Probability oneInDice = new Probability(0.1667);

        Probability notOneInDice = oneInDice.getInverseProbability();
        assertEquals(0.833, notOneInDice.value(), 0.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGettingProbabilityWithValueGreaterThanOneShouldThrowException() throws Exception {
        Probability probability = new Probability(1.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenProbabilityLessThanZero() {
        Probability probability = new Probability(-0.1);
    }

    @Test
    public void testCreatingProbabilityWithZero() {
        Probability probability = new Probability(0);

        assertEquals(0.0, probability.value(), 0.1);
    }

    @Test
    public void testCreatingProbabilityWithOne() {
        Probability probability = new Probability(1);

        assertEquals(1.0, probability.value(), 0.1);
    }

    @Test
    public void testGettingProbabilityWithOutcomes() {
        Probability probability = new Probability(3, 4);

        assertEquals(0.75, probability.value());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenWrongProbabilityWithDivision() {
        Probability probability = new Probability(4, 3);
    }

    @Test
    public void testGettingProbabilityOfTwoEventsHappeningTogether() {
        Probability oneInDice = new Probability((double)1/6);

        Probability oneInTwoDice = oneInDice.and(oneInDice);

        assertEquals(0.0277,oneInTwoDice.value(),0.3);
    }

    @Test
    public void testProbabilityOfEitherOfEventsHappening() {
        Probability oneInDice = new Probability(0.5);
        Probability expected = new Probability(0.75);

        Probability oneOnEitherDice = oneInDice.or(oneInDice);

        assertEquals(true,expected.equals(oneOnEitherDice));
    }

    @Test
    public void testGettingExOr() {
        Probability oneInDice = new Probability(0.5);
        Probability expected = new Probability(0.5);

        Probability exOrProbability = oneInDice.exOr(oneInDice);

        assertEquals(true,expected.equals(exOrProbability));
    }
}