package com.pallavig.measurement.units;

public enum LengthUnit implements Unit {
    MILLIMETER(1),
    CENTIMETER(0.1),
    METER(0.001),
    KILOMETER(0.000001),
    INCH(0.0393701),
    FEET(0.00328084),
    MILE(0.000000621371),
    YARD(0.00109361);
    private double multiplier;

    LengthUnit(double multiplier) {

        this.multiplier = multiplier;
    }

    @Override
    public double getMultiplicationFactor() {
        return multiplier;
    }
}
