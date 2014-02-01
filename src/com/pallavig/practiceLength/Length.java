package com.pallavig.practiceLength;

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
        if(this.getUnit().getClass() != unit.getClass())
            throw new IllegalArgumentException("Not a valid parameter");
        double value = (this.getLength()*unit.getMultiplicationFactor())/this.getUnit().getMultiplicationFactor();
        return new Length(value,unit);
    }
}