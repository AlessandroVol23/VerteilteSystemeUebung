package de.oth.vs.rest;

import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;

public class StudentResource {

    public Student getStudentById(int id) {

    Student s = new Student("Sandro", "Volpicella", 1, new Address("Rosenstrasse", "Taufkirchen"), 250);


        System.out.println("In getStudentByID...");

        return s;


    }

    public void deleteStudentById(int id) {
        System.out.println("In deleteStudentById...");

    }

    public Student[] getStudentsByIdRange(int from, int to) {
        Student s = new Student("Sandro", "Volpicella", 1, new Address("Rosenstrasse", "Taufkirchen"), 250);
        Student m = new Student("Marie", "Diep", 2, new Address("Prizn", "Rgb"), 250);

        Student[] studentArray = new Student[2];
        studentArray[0] = s;
        studentArray[1] = m;

        System.out.println("In getStudentsByIdRange...");

        return studentArray;

    }
}
