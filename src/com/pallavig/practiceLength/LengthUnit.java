package com.pallavig.practiceLength;

public enum LengthUnit implements Unit {
    MILLIMETER(1),
    CENTIMETER(0.1),
    METER(0.001);
    private double multiplier;

    LengthUnit(double multiplier) {

        this.multiplier = multiplier;
    }

    @Override
    public double getMultiplicationFactor() {
        return multiplier;
    }
}
