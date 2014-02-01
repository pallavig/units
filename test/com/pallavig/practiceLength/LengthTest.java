package com.pallavig.practiceLength;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LengthTest {
    @Test
    public void testCreatingLength() throws Exception {
        Length length = new Length(1,LengthUnit.CENTIMETER);

        assertEquals(1.0,length.getLength());
        assertEquals(LengthUnit.CENTIMETER,length.getUnit());
    }

    @Test
    public void testConvertLengthFromMeterToCentimeter() throws Exception {
        Length lengthInMeter = new Length(1,LengthUnit.METER);

        Length lengthInCentimeter = lengthInMeter.convert(LengthUnit.CENTIMETER);

        assertEquals(100.0,lengthInCentimeter.getLength());
        assertEquals(LengthUnit.CENTIMETER,lengthInCentimeter.getUnit());
    }

    @Test
    public void testConvertingMilliliterToLiter() {
        Length volumeInLiter = new Length(1,VolumeUnit.LITTER);

        Length volumeInMilliliter = volumeInLiter.convert(VolumeUnit.MILLILITER);

        assertEquals(1000.0,volumeInMilliliter.getLength());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConversion() {
        Length volumeInLiter = new Length(1,VolumeUnit.LITTER);

        volumeInLiter.convert(LengthUnit.CENTIMETER);
    }
}