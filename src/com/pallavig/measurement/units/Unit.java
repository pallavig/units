package com.pallavig.measurement.units;

public interface Unit {
        public double compareTo(Unit unit);
        double getMultiplicationFactor();
}
