package com.pallavig.practiceLength;

public abstract class Measure {
    private double value;
    private Unit unit;

    protected Measure(double value, Unit unit) {
        if(value < 0)
            throw new IllegalArgumentException("Negative value is not allowed");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
