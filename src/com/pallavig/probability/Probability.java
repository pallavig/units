package com.pallavig.probability;

public class Probability {
    private final Double probability;

    @Override
    public boolean equals(Object obj) {
        Probability p = (Probability) obj;
        return this.probability.equals(p.probability);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Probability(double probability) {
        if (probability < 0 || probability > 1)
            throw new IllegalArgumentException("Value should be between 0 and 1");
        this.probability = probability;
    }

    public Probability(double a, double b) {
        this(a/b);
    }

    public double value() {
        return probability;
    }

    public Probability getInverseProbability() {
        return new Probability(1-probability);
    }

    public Probability and(Probability p) {
        return new Probability(this.probability * p.probability);
    }

    public Probability or(Probability p) {
        Probability andProbability = this.and(p);
        double probabilityOfNewObject = (this.probability+p.probability)-andProbability.probability;
        return new Probability(probabilityOfNewObject);
    }

    public Probability exOr(Probability p) {
        Probability andProbability = this.and(p);
        Probability orProbability = this.or(p);
        return new Probability(orProbability.probability - andProbability.probability);
    }
}