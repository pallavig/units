package com.pallavig.measurement.measures;

import com.pallavig.measurement.units.LengthUnit;

public class Length extends Measure {

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;
        Length length1 = length.convert(LengthUnit.METER);
        Length length2 = this.convert(LengthUnit.METER);

        int value1 = (int)Math.round(length1.getValue()*100);
        int value2 = (int)Math.round(length2.getValue()*100);
        if(!(value1==value2)) return false;

        if(length1.getUnit().getClass() != length2.getUnit().getClass()) return false;

        return true;
    }

    public Length convert(LengthUnit unit) {
        double value = convertToSpecificUnitValue(unit);
        return new Length(value,unit);
    }

    public Length add(Length length) {
        Length lengthInCalledObjectsUnit = length.convert((LengthUnit)this.getUnit());
        return new Length(this.getValue()+lengthInCalledObjectsUnit.getValue(),(LengthUnit)this.getUnit());
    }
}