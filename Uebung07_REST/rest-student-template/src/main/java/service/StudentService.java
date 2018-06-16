package service;

import entity.Address;
import entity.Pruefungsleistung;
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
            // Changed from Class.forName("com.mysql.jdbc.Driver") because this is deprecated
            //Class.forName("com.mysql.cj.jdbc.Driver");
            // IP  194.95.108.2
            Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");
            System.out.println("Connected to Database.");

            Statement statement = c.createStatement();
            PreparedStatement pStmt = null;
            String query = "SELECT * FROM Student Where matrikelNr = ?";
            pStmt = c.prepareStatement(query);
            pStmt.setInt(1, studentId);


            System.out.println("Executing query...");
            ResultSet rs = pStmt.executeQuery();

            //ResultSet rs = statement.executeQuery(query);

            rs.first();
            String studentVn = rs.getString("vorname");
            String studentNn = rs.getString("nachname");
            int studentEcts = rs.getInt("ects");
            String studentStreet = rs.getString("strasse");
            String studentCity = rs.getString("ort");

            Student newStudent = new Student(studentId, studentVn, studentNn, new Address(studentStreet, studentCity), studentEcts);


            c.close();
            return newStudent;
        } //catch (ClassNotFoundException e) {
        // e.printStackTrace();
        //}
        catch (SQLException e) {
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


    @Path("students/{id}/addExam")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Pruefungsleistung pruefungsleistungResource(@PathParam("id") int studentId, Pruefungsleistung newExam) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");
            System.out.println("Connection to database established!");

            con.setAutoCommit(false);

            PreparedStatement insertStmt = null;
            String insertQuery = "INSERT INTO Pruefungsleistung (pruefungId, matrikelNr, versuch, note) VALUES (?, ?, ?, ?)";
            insertStmt = con.prepareStatement(insertQuery);
            insertStmt.setString(1, newExam.getPruefungID());
            insertStmt.setInt(2,studentId);
            insertStmt.setInt(3,newExam.getVersuch());
            insertStmt.setDouble(4, newExam.getNote());

            insertStmt.execute();

            // Update ECTS in Student
            PreparedStatement selectStmt = null;
            String selQuery = "SELECT ects from Pruefung WHERE pruefungId = ?";
            selectStmt = con.prepareStatement(selQuery);

            selectStmt.setString(1, newExam.getPruefungID());

            ResultSet rs = selectStmt.executeQuery();
            rs.first();
            int ectsToAdd = rs.getInt(1);
            System.out.println("ECTS to add: " + ectsToAdd);

            // Add ECTS to student

            // Get current ects

            PreparedStatement selectStmtEcts = null;
            String selEctsQuery = "SELECT ects from Student Where matrikelNr = ?";
            selectStmtEcts = con.prepareStatement(selEctsQuery);
            selectStmtEcts.setInt(1,studentId);
            ResultSet rs2 = selectStmtEcts.executeQuery();
            rs2.first();
            int currentEcts = rs2.getInt(1);
            System.out.println("Current ECTS are: " +currentEcts);


            PreparedStatement updateStmt = null;
            String updateQuery = "UPDATE Student SET ects = ? WHERE matrikelNr = ?";
            updateStmt = con.prepareStatement(updateQuery);
            int newEcts = currentEcts + ectsToAdd;

            updateStmt.setInt(1,newEcts);
            updateStmt.setInt(2, studentId);

            updateStmt.executeUpdate();
            System.out.println("Update done!");

            con.commit();
            con.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return newExam;
    }
    @Path("students/{id}/getExams")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pruefungsleistung> getPruefungsleistungFromStudent(@PathParam("id") int studentId) {

        System.out.println("getPruefungsleistungFromStudent...");
        ArrayList<Pruefungsleistung> pruefungsleistungenStudent = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");
            PreparedStatement selectStmt = null;
            String query = "SELECT * FROM Pruefungsleistung WHERE matrikelNr = ?";

            selectStmt = con.prepareStatement(query);
            selectStmt.setInt(1,studentId);


            ResultSet rs = selectStmt.executeQuery();

            while(rs.next()) {
                String pruefungID = rs.getString(2);
                int versuch = rs.getInt(4);
                double note = rs.getDouble(5);
                Pruefungsleistung pl = new Pruefungsleistung(studentId, pruefungID, versuch, note);
                pruefungsleistungenStudent.add(pl);
                // System.out.println(pl.toString());
            }



        } catch(SQLException e) {
            e.printStackTrace();
        }

        return pruefungsleistungenStudent;
    }
}
