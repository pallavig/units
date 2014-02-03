package com.pallavig.measurement.measures;

import com.pallavig.measurement.units.VolumeUnit;

public class Volume extends Measure {
    public Volume(double value, VolumeUnit unit) {
        super(value, unit);
    }

    private Volume(Measure m) {
        super(m.getValue(),(VolumeUnit)m.getUnit());
    }

    public Volume convert(VolumeUnit unit) {
        return new Volume(super.convert(unit));
    }

    public Volume add(Volume volume) {
        return new Volume(super.add(volume));
    }

    public double compareTo(Volume volume) {
        return super.compareTo(volume);
    }
}