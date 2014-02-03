package com.pallavig.measurement.measures;

import com.pallavig.measurement.units.LengthUnit;

public class Length extends Measure {

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    private Length(Measure m){
        super(m.getValue(),(LengthUnit)m.getUnit());
    }

    public Length convert(LengthUnit unit) {
        return new Length(super.convert(unit));
    }

    public double compareTo(Length length) {
        return super.compareTo(length);
    }

    public Length add(Length length) {
        return new Length(super.add(length));
    }
}