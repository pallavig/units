package com.pallavig.measurement.measures;

import com.pallavig.measurement.units.Unit;

public class Measure {
    private double value;
    private Unit unit;

    protected Measure(double value, Unit unit) {
        if (value < 0)
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

    protected Measure convert(Unit unit) {
        double value = (this.getValue() * unit.getMultiplicationFactor()) / this.getUnit().getMultiplicationFactor();
        return new Measure(value, unit);
    }

    protected double compareTo(Measure measure) {
        Measure measureInCalledObjectsUnit = measure.convert(this.getUnit());
        return this.getValue() - measureInCalledObjectsUnit.getValue();
    }

    protected Measure add(Measure measure) {
        Measure measureOneToAdd, measureTwoToAdd;
        if (this.getUnit().compareTo(measure.getUnit()) > 0) {
            measureOneToAdd = measure.convert(this.getUnit());
            measureTwoToAdd = this;
        } else {
            measureOneToAdd = this.convert(measure.getUnit());
            measureTwoToAdd = measure;
        }
        return new Measure(measureOneToAdd.getValue() + measureTwoToAdd.getValue(), measureOneToAdd.getUnit());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measure measure = (Measure) o;

        if (Double.compare(measure.getValue(), this.convert(measure.getUnit()).getValue()) != 0) return false;

        return true;
    }
}