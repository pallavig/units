package com.pallavig.practiceLength;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class VolumeTest {
    @Test
    public void testCreatingVolume() {
        Volume volumeInLiter = new Volume(1,VolumeUnit.LITTER);

        assertEquals(1.0,volumeInLiter.getValue());
        assertEquals(VolumeUnit.LITTER,volumeInLiter.getUnit());
    }

    @Test
    public void testConvertingMilliliterToLiter() {
        Volume volumeInLiter = new Volume(1,VolumeUnit.LITTER);

        Volume volumeInMilliliter = volumeInLiter.convert(VolumeUnit.MILLILITER);

        assertEquals(volumeInMilliliter,volumeInLiter);
        assertEquals(1000.0,volumeInMilliliter.getValue());
        assertEquals(VolumeUnit.MILLILITER,volumeInMilliliter.getUnit());
    }
}
