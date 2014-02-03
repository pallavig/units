package com.pallavig.practiceLength.measures;

import com.pallavig.practiceLength.units.VolumeUnit;

public class Volume extends Measure {
    public Volume(double value, VolumeUnit unit) {
        super(value, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;
        Volume volume1 = volume.convert(VolumeUnit.MILLILITER);
        Volume volume2 = this.convert(VolumeUnit.MILLILITER);

        int value1 = (int)Math.round(volume1.getValue()*100);
        int value2 = (int)Math.round(volume2.getValue()*100);
        if(!(value1==value2)) return false;

        if(volume1.getUnit().getClass() != volume2.getUnit().getClass()) return false;

        return true;
    }

    public Volume convert(VolumeUnit unit) {
        double value = convertToSpecificUnitValue(unit);
        return new Volume(value,unit);
    }

    public Volume add(Volume volume) {
        Volume volumeInCalledObjectsUnit = volume.convert((VolumeUnit)this.getUnit());
        return new Volume(this.getValue()+volumeInCalledObjectsUnit.getValue(),(VolumeUnit)this.getUnit());
    }
}