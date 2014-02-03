package com.pallavig.practiceLength.units;

import com.pallavig.practiceLength.units.Unit;

public enum VolumeUnit implements Unit {
    MILLILITER(1),
    LITTER(0.001),
    KILOLITER(0.000001),
    GALLON(0.000264172);
    private double multiplier;

    VolumeUnit(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double getMultiplicationFactor() {
        return multiplier;
    }
}
