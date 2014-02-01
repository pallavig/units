package com.pallavig.practiceLength;

public enum VolumeUnit implements Unit {
    MILLILITER(1),
    LITTER(0.001);
    private double multiplier;

    VolumeUnit(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double getMultiplicationFactor() {
        return multiplier;
    }
}
