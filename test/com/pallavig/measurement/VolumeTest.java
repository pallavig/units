package com.pallavig.measurement;

import com.pallavig.measurement.measures.Measure;
import com.pallavig.measurement.measures.Volume;
import com.pallavig.measurement.units.VolumeUnit;
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

    @Test
    public void testComparingWhenFirstVolumeGreaterThanSecond(){
        Volume volume1 = new Volume(1,VolumeUnit.LITTER);
        Volume volume2 = new Volume(999,VolumeUnit.MILLILITER);

        assertEquals(0.001, volume1.compareTo(volume2), 0.3);
    }

    @Test
    public void testComparingWhenFirstLengthSmallerThanSecond(){
        Volume volume1 = new Volume(999,VolumeUnit.MILLILITER);
        Volume volume2 = new Volume(1,VolumeUnit.LITTER);

        assertEquals(-1,volume1.compareTo(volume2),0.2);
    }

    @Test
    public void testComparingTwoEqualVolumes(){
        Volume volume1 = new Volume(1,VolumeUnit.LITTER);
        Volume volume2 = new Volume(1000,VolumeUnit.MILLILITER);

        assertEquals(0.0,volume1.compareTo(volume2));
    }

    @Test
    public void testAddingVolumesHavingSameUnit() {
        Volume volume1 = new Volume(1,VolumeUnit.LITTER);
        Volume volume2 = new Volume(1,VolumeUnit.LITTER);
        Volume expected  = new Volume(2,VolumeUnit.LITTER);

        Volume actual = volume1.add(volume2);

        assertEquals(expected,actual);
    }

    @Test
    public void testAddingVolumesHavingDifferentUnit() {
        Volume volume1 = new Volume(2000,VolumeUnit.MILLILITER);
        Volume volume2 = new Volume(2,VolumeUnit.LITTER);
        Volume expected = new Volume(4,VolumeUnit.LITTER);

        Volume actual = volume1.add(volume2);

        assertEquals(expected,actual);
    }
}