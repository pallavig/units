package com.pallavig.shapes;

import com.pallavig.shapes.Rectangle;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void testCalculatingAreaOfRectangle() {
        Rectangle rectangle = Rectangle.createRectangle(3,2);
        assertEquals(6.0,rectangle.getArea());
    }

    @Test
    public void testCalculatingPerimeterOfRectangle() {
        Rectangle rectangle = Rectangle.createRectangle(3,2);
        assertEquals(10.0,rectangle.getPerimeter());
    }
}