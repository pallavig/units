package com.pallavig.practiceLength;

import com.pallavig.practiceLength.measures.Length;
import com.pallavig.practiceLength.units.LengthUnit;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class LengthTest {
    @Test
    public void testCreatingLength() throws Exception {
        Length length = new Length(1, LengthUnit.CENTIMETER);

        assertEquals(1.0,length.getValue());
        assertEquals(LengthUnit.CENTIMETER,length.getUnit());
    }

    @Test
    public void testEqualsWithSameUnit() {
        Length length1 = new Length(1,LengthUnit.CENTIMETER);
        Length length2 = new Length(1,LengthUnit.CENTIMETER);

        assertEquals(length1,length2);
    }

    @Test
    public void testEqualsWIthDifferentUnit() {
        Length lengthInMeter = new Length(1,LengthUnit.METER);
        Length lengthInCentimeter = new Length(100,LengthUnit.CENTIMETER);

        assertEquals(lengthInCentimeter,lengthInMeter);
    }

    @Test
    public void testConvertLengthFromMeterToCentimeter() throws Exception {
        Length lengthInMeter = new Length(1,LengthUnit.METER);

        Length lengthInCentimeter = lengthInMeter.convert(LengthUnit.CENTIMETER);

        assertEquals(100.0,lengthInCentimeter.getValue());
        assertEquals(LengthUnit.CENTIMETER,lengthInCentimeter.getUnit());
    }

    @Test
    public void testGetLength() {
        Length length = new Length(6.0,LengthUnit.FEET);
        assertEquals(6.0, length.getValue());
        assertEquals(LengthUnit.FEET, length.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorOnProbabilityOutOfRange() {
        new Length(-2.1,LengthUnit.FEET);
    }

    @Test
    public void convertLengthMeterToCentiMeter(){
        Length lengthInMeter = new Length(1.0,LengthUnit.METER);

        Length lengthInCentimeter = lengthInMeter.convert(LengthUnit.CENTIMETER);
        assertEquals(lengthInMeter,lengthInCentimeter);
    }

    @Test
    public void testConvertLengthMileToMillimeter() {
        Length lengthInMile = new Length(1.0,LengthUnit.MILE);

        Length lengthInMillimeter = lengthInMile.convert(LengthUnit.MILLIMETER);
        assertEquals(lengthInMillimeter,lengthInMile);
    }

    @Test
    public void testConvertLengthYardToCentimeter() {
        Length lengthInYard = new Length(1.0,LengthUnit.YARD);

        Length lengthInCentimeter = lengthInYard.convert(LengthUnit.CENTIMETER);
        assertEquals(true,lengthInYard.equals(lengthInCentimeter));
    }

    @Test
    public void testAddingLengthsOfSameUnit() {
        Length length1 = new Length(100,LengthUnit.CENTIMETER);
        Length length2 = new Length(200,LengthUnit.CENTIMETER);
        Length expected = new Length(300,LengthUnit.CENTIMETER);

        Length actual = length1.add(length2);

        assertEquals(expected,actual);
    }

    @Test
    public void testAddingLengthsOfDifferentUnits() {
        Length length1 = new Length(2,LengthUnit.KILOMETER);
        Length length2 = new Length(1000,LengthUnit.METER);
        Length expected = new Length(3.0,LengthUnit.KILOMETER);

        Length actual = length1.add(length2);

        assertEquals(expected,actual);
    }
}