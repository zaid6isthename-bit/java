class Experiment4Hierarchical {

    static class Animal {

        void eat() {
            System.out.println("Animal is eating.");
        }
    }

    static class Dog extends Animal {

        void bark() {
            System.out.println("Dog is barking.");
        }
    }

    static class Cat extends Animal {

        void meow() {
            System.out.println("Cat is meowing.");
        }
    }

    public static void main(String[] args) {

        Dog myDog = new Dog();

        myDog.eat();
        myDog.bark();

        System.out.println();

        Cat myCat = new Cat();

        myCat.eat();
        myCat.meow();
    }
}