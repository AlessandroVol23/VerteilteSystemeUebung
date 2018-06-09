package service;

import entity.Address;
import entity.Student;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.*;

@Path("studentaffairs")
public class StudentService {

    private static int nextStudentId = 1;
    private static ArrayList<Student> studentDB = new ArrayList<>();

    public StudentService() {
        if (nextStudentId == 1) {
            Student s = new Student(nextStudentId++, "Sandro", "Volpicella", new Address("Rosenstrasse", "88888", "Munich"));
            studentDB.add(s);
        }

    }

    @Path("students")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student immatriculate(Student s) {

        System.out.println("Immatriculate: " + s.getVorname() + " " + s.getNachname());
        Student newStudent = new Student(nextStudentId++, s.getVorname(), s.getNachname(), s.getAddress());
        studentDB.add(newStudent);
        return newStudent;

    }

    @Path("students/{id}")
    @DELETE
    public Student exmatriculate(@PathParam("id") int studentId) {

        Student dummyStudent = new Student();
        dummyStudent.setMatrikelNr(studentId);
        if (studentDB.remove(dummyStudent)) {
            System.out.println("Exmatriculate: " + studentId + " deleted");
        } else {
            System.out.println("exmatriculate: Some Error");
        }

        return dummyStudent;

    }

    @Path("students/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") int studentId) {
        // Aufgabe 07
        /*
        System.out.println("getStudentById: " + studentId);

        Student s = new Student();
        s.setMatrikelNr(studentId);
        s = studentDB.get(studentDB.indexOf(s));

        return s;
        */

        // Aufgabe 08
        System.out.println("getStudentById: " + studentId);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011", "vs-08", "vs-08-pw");

            Statement statement = c.createStatement();
            String query = "SELECT * FROM Student Where matrikelNr = 1234";
            ResultSet rs = statement.executeQuery(query);

            rs.first();
            String studentVn = rs.getString("vorname");
            String studentNn = rs.getString("nachname");
            int studentEcts = rs.getInt("ects");
            String studentStreet = rs.getString("strasse");
            String studentCity = rs.getString("ort");

            Student newStudent = new Student(studentId, studentVn, studentNn, new Address(studentStreet, studentCity));


            c.close();
            return newStudent;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Path("students/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudentAccount(@PathParam("id") int studentId, Student newData) {

        System.out.println("updateStudentAccount with id: " + studentId);
        Student newStudent = new Student(studentId, newData.getVorname(), newData.getNachname(), newData.getAddress());

        // Equals just looks for the studentID
        int index = studentDB.indexOf(newStudent);
        studentDB.set(index, newStudent);

        return newStudent;
    }

    @Path("students/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {

        System.out.println("getAllStudents: Return all students");
        return studentDB;


    }

    @Path("students/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudentsByRange(@QueryParam("fromId") int fromStudentId,
                                            @QueryParam("toId") int toStudentId) {

        ArrayList<Student> studentRange = new ArrayList<>();

        for (Student s : studentDB) {
            if (s.getMatrikelNr() >= fromStudentId && s.getMatrikelNr() <= toStudentId) {
                studentRange.add(s);
            }
        }
        System.out.println("getStudentsByRange: Return students in range");

        return studentRange;


    }
}
