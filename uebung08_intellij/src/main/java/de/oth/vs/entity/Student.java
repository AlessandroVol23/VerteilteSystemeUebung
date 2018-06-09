package de.oth.vs.entity;

public class Student {

    private String firstName;
    private String lastName;
    private int studentNumber;
    private Address address;
    private int ECTS;

    public Student() {

    }

    public Student(String firstName, String lastName, int studentNumber, Address address, int ECTS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.address = address;
        this.ECTS = ECTS;
    }
}
