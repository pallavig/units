package com.pallavig.shapes;

public class Rectangle {
    private double width,height;
    private Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea(){
        return width*height;
    }

    public double getPerimeter() {
        return 2 *(width+height);
    }

    public static Rectangle createRectangle(int width,int height) {
        Rectangle rectangle = new Rectangle(width,height);
        return rectangle;
    }

    public static Rectangle createSquare(int length) {
        Rectangle rectangle = new Rectangle(length,length);
        return rectangle;
    }
}