class Experiment4Multiple {

    interface Swimmer {
        void swim();
    }

    interface Runner {
        void run();
    }

    static class Athlete implements Swimmer, Runner {

        public void swim() {
            System.out.println("Athlete is swimming.");
        }

        public void run() {
            System.out.println("Athlete is running.");
        }

        void train() {
            System.out.println("Athlete is training hard.");
        }
    }

    public static void main(String[] args) {

        Athlete athlete = new Athlete();

        athlete.swim();
        athlete.run();
        athlete.train();
    }
}