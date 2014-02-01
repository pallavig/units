package com.pallavig.length;

public abstract class Unit {
    private final int equalsCentimeter;

    public Unit(int value) {
        equalsCentimeter = value;
    }

    public static final Meter METER = new Meter(100);
    public static final Centimeter CENTIMETER = new Centimeter(1);

    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            return true;
        }
        return false;
    }

    public int getCentimeterEquivalent() {
        return equalsCentimeter;
    }

    public double getInSpecifiedUnit(Length length) {
        return (length.getLength()*length.getUnit().getCentimeterEquivalent()) / this.getCentimeterEquivalent();
    }
}