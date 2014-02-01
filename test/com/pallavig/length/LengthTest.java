package com.pallavig.length;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LengthTest {
    @Test
    public void testCreateLengthWithMeter() {
        Length length = new Length(10, Unit.METER);

        assertEquals(10.0, length.getLength());
        assertEquals(Unit.METER, length.getUnit());
    }

    @Test
    public void testCreateLengthWithCentimeter() {
        Length length = new Length(10, Unit.CENTIMETER);

        assertEquals(10.0, length.getLength());
        assertEquals(Unit.CENTIMETER, length.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateLengthWithNegativeValue() {
        Length length = new Length(-1, Unit.CENTIMETER);
    }

    @Test
    public void testConvertFromMeterToCentimeter() {
        Length length = new Length(1, Unit.METER);

        Length lengthInCentimeter = length.convert(Unit.CENTIMETER);

        assertEquals(100.0, lengthInCentimeter.getLength());
        assertEquals(Unit.CENTIMETER, lengthInCentimeter.getUnit());
    }


    @Test
    public void testConvertFromCentimeterToMeter() {
        Length length = new Length(100, Unit.CENTIMETER);

        Length lengthInCentimeter = length.convert(Unit.METER);

        assertEquals(1.0, lengthInCentimeter.getLength());
        assertEquals(Unit.METER, lengthInCentimeter.getUnit());
    }
}