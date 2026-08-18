class Experiment3 {

    static class Box {

        double width;
        double height;
        double depth;

        // Constructor with all dimensions
        Box(double w, double h, double d) {
            width = w;
            height = h;
            depth = d;
        }

        // Default constructor
        Box() {
            width = height = depth = 0;
        }

        // Constructor for cube
        Box(double len) {
            width = height = depth = len;
        }

        // Calculate volume
        double volume() {
            return width * height * depth;
        }
    }

    public static void main(String[] args) {

        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box();
        Box mycube = new Box(7);

        System.out.println("Volume of mybox1 is " + mybox1.volume());
        System.out.println("Volume of mybox2 is " + mybox2.volume());
        System.out.println("Volume of mycube is " + mycube.volume());
    }
}