class Experiment5 {

    public static void main(String[] args) {

        // Example 1: ArithmeticException
        try {

            int result = 10 / 0;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            System.out.println(
                "Error: Division by zero is not allowed!"
            );

            System.out.println(
                "Exception details: " + e.getMessage()
            );

        } finally {

            System.out.println(
                "Finally block executed after handling ArithmeticException."
            );
        }

        System.out.println("\n--- Next Example ---\n");

        // Example 2: ArrayIndexOutOfBoundsException
        try {

            int[] numbers = {1, 2, 3};

            System.out.println(
                "Element at index 5: " + numbers[5]
            );

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                "Error: Array index out of bounds!"
            );

            System.out.println(
                "Exception details: " + e.getMessage()
            );

        } finally {

            System.out.println(
                "Finally block executed after handling " +
                "ArrayIndexOutOfBoundsException."
            );
        }

        System.out.println(
            "\nProgram continues after all exception handling."
        );
    }
}