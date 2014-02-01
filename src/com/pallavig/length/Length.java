package com.pallavig.length;

public class Length {
    private double length;
    private Unit unit;

    public Length(double length, Unit unit) {
        if (length < 0)
            throw new IllegalArgumentException("Length can not be negative");
        this.length = length;
        this.unit = unit;
    }

    public double getLength() {
        return length;
    }

    public Unit getUnit() {
        return unit;
    }

    public Length convert(Unit unit) {
        double value = unit.getInSpecifiedUnit(this);
        return new Length(value, unit);
    }
}
