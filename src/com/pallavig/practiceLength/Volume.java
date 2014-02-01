package com.pallavig.practiceLength;

public class Volume extends Measure{
    public Volume(double value, VolumeUnit unit) {
        super(value, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;
        Volume length1 = volume.convert(VolumeUnit.MILLILITER);
        Volume length2 = this.convert(VolumeUnit.MILLILITER);

        int value1 = (int)Math.round(length1.getValue()*100);
        int value2 = (int)Math.round(length2.getValue()*100);
        if(!(value1==value2)) return false;

        if(length1.getUnit().getMultiplicationFactor() != length2.getUnit().getMultiplicationFactor()) return false;

        return true;
    }

    public Volume convert(VolumeUnit unit) {
        double value = (this.getValue()*unit.getMultiplicationFactor())/this.getUnit().getMultiplicationFactor();
        return new Volume(value,unit);
    }
}