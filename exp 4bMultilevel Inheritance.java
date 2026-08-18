class Experiment4Multilevel {

    static class Vehicle {

        void displayVehicleType() {
            System.out.println("This is a generic vehicle.");
        }
    }

    static class Car extends Vehicle {

        void displayCarDetails() {
            System.out.println("This is a car.");
        }
    }

    static class SportsCar extends Car {

        void displaySportsCarDetails() {
            System.out.println("This is a sports car.");
        }
    }

    public static void main(String[] args) {

        SportsCar mySportsCar = new SportsCar();

        mySportsCar.displayVehicleType();
        mySportsCar.displayCarDetails();
        mySportsCar.displaySportsCarDetails();
    }
}