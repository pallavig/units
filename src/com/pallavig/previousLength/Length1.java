package com.pallavig.previousLength;

public class Length1 {
        private double length;

        Length1(double length) {
            if(length < 0)
                throw new IllegalArgumentException("Length cant be negative");
            this.length = length;
        }

        public static Length1 createLengthWithMeter(double lengthInMeter) {
            return new Length1(lengthInMeter);
        }

        public double getLength(String unit){
            if(unit.equals("meter"))
                return this.getLengthInMeter();
            return 0;
        }

        public double getLengthInMeter() {
            return this.length;
        }

        public static Length1 createLengthWithCentimeter(double lengthInCentimeter) {
            return new Length1(lengthInCentimeter/100);
        }

        public static Length1 createLength(double length,String unit) {
            if(unit.equals("meter"))
                return Length1.createLengthWithMeter(length);
            if(unit.equals("centimeter"))
                return Length1.createLengthWithCentimeter(length);
            return null;
//        throw new IllegalArgumentException("Illegal unit specified");
        }
}
