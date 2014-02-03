package com.pallavig.practiceLength;

import com.pallavig.practiceLength.measures.Volume;
import com.pallavig.practiceLength.units.VolumeUnit;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class VolumeTest {
    @Test
    public void testCreatingVolume() {
        Volume volumeInLiter = new Volume(1, VolumeUnit.LITTER);

        assertEquals(1.0,volumeInLiter.getValue());
        assertEquals(VolumeUnit.LITTER,volumeInLiter.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingVolumeWithNegativeValue() {
        Volume volume = new Volume(-1,VolumeUnit.GALLON);
    }

    @Test
    public void testEqualsWithSameUnit() {
        Volume volume1 = new Volume(100,VolumeUnit.GALLON);
        Volume volume2 = new Volume(100,VolumeUnit.GALLON);

        assertEquals(volume1,volume2);
    }

    @Test
    public void testEqualsWithDifferentUnits() {
        Volume volumeInLitter = new Volume(1,VolumeUnit.LITTER);
        Volume volumeInMilliliter = new Volume(1000,VolumeUnit.MILLILITER);

        assertEquals(volumeInLitter,volumeInMilliliter);
    }

    @Test
    public void testConvertingMilliliterToLiter() {
        Volume volumeInLiter = new Volume(1,VolumeUnit.LITTER);

        Volume volumeInMilliliter = volumeInLiter.convert(VolumeUnit.MILLILITER);

        assertEquals(volumeInMilliliter,volumeInLiter);
        assertEquals(1000.0,volumeInMilliliter.getValue());
        assertEquals(VolumeUnit.MILLILITER,volumeInMilliliter.getUnit());
    }

    @Test
    public void testAddingVolumesWithSameUnit() {
        Volume volume1 = new Volume(1000,VolumeUnit.MILLILITER);
        Volume volume2 = new Volume(200,VolumeUnit.MILLILITER);
        Volume expected = new Volume(1200,VolumeUnit.MILLILITER);

        Volume actual = volume1.add(volume2);

        assertEquals(expected,actual);
    }

    @Test
    public void testAddingVolumesWithDifferentUnit() {
        Volume volume1 = new Volume(1000,VolumeUnit.MILLILITER);
        Volume volume2 = new Volume(2,VolumeUnit.LITTER);
        Volume expected = new Volume(3000,VolumeUnit.MILLILITER);

        Volume actual = volume1.add(volume2);

        assertEquals(expected,actual);
    }
}