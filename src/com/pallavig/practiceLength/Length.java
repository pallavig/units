package com.pallavig.practiceLength;

public class Length extends Measure{

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

        if(length1.getUnit().getMultiplicationFactor() != length2.getUnit().getMultiplicationFactor()) return false;

        return true;
    }


    public Length convert(LengthUnit unit) {
        double value = (this.getValue()*unit.getMultiplicationFactor())/this.getUnit().getMultiplicationFactor();
        return new Length(value,unit);
    }
}