package com.pallavig.shapes;

import com.pallavig.shapes.Rectangle;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SquareTest {
    @Test
    public void testCalculatingAreaOfSquare() {
        Rectangle square = Rectangle.createSquare(3);

        assertEquals(9.0,square.getArea());
    }

    @Test
    public void testCalculatingPerimeterOfSquare() {
        Rectangle square = Rectangle.createSquare(3);

        assertEquals(12.0,square.getPerimeter());
    }
}