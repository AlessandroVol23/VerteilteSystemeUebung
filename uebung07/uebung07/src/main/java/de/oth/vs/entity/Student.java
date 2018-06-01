
package de.oth.vs.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    
    @XmlAttribute
    private int matrikelnr;
    private String vorname;
    private String nachname;
    private int ECTS;
    private Adresse anschrift;
    public static ArrayList<Student> studentList = new ArrayList<>();

    public Student() {
    }
    
    

    public Student(int matrikelnr, String vorname, String nachname, int ECTS, Adresse anschrift) {
        this.matrikelnr = matrikelnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.ECTS = ECTS;
        this.anschrift = anschrift;
        studentList.add(this);
    }
    
    
    
    public static Student getStudentById(int id) {
        for(Student s : studentList) {
            if(s.matrikelnr == id) {
                return s;
            }
        }
        return null;
    }

    public int getMatrikelnr() {
        return matrikelnr;
    }

    public void setMatrikelnr(int matrikelnr) {
        this.matrikelnr = matrikelnr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public Adresse getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(Adresse anschrift) {
        this.anschrift = anschrift;
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        Student.studentList = studentList;
    }
    
    
    
    

    
}
