class Experiment2 {

    static class AreaCalculator {

        void calculateArea(double side) {
            System.out.println("Area of Square: " + (side * side));
        }

        void calculateArea(double length, double width) {
            System.out.println("Area of Rectangle: " + (length * width));
        }

        void calculateArea(float radius) {
            System.out.println("Area of Circle: "
                    + (Math.PI * radius * radius));
        }
    }

    public static void main(String[] args) {

        AreaCalculator calculator = new AreaCalculator();

        calculator.calculateArea(5.0);
        calculator.calculateArea(10.0, 4.0);
        calculator.calculateArea(3.5f);
    }
}