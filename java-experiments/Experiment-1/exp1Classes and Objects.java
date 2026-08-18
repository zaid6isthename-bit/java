class Experiment1 {

    static class Employee {
        int id;
        String name;
        float salary;

        void insert(int i, String n, float s) {
            id = i;
            name = n;
            salary = s;
        }

        void display() {
            System.out.println(id + " " + name + " " + salary);
        }
    }

    static class Student {
        int rollno;
        String name;

        void insertRecord(int r, String n) {
            rollno = r;
            name = n;
        }

        void displayInformation() {
            System.out.println(rollno + " " + name);
        }
    }

    public static void main(String[] args) {

        // Employee objects
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();

        e1.insert(101, "ajeet", 45000);
        e2.insert(102, "irfan", 25000);
        e3.insert(103, "nakul", 55000);

        e1.display();
        e2.display();
        e3.display();

        System.out.println();

        // Student objects
        Student s1 = new Student();
        Student s2 = new Student();

        s1.insertRecord(111, "Karan");
        s2.insertRecord(222, "Aryan");

        s1.displayInformation();
        s2.displayInformation();
    }
}