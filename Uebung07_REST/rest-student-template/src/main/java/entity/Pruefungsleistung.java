package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pruefungsleistung {

    private String pruefungID;
    private int versuch;
    private double note;
    private int studentID;

    public Pruefungsleistung() {
        this.pruefungID = pruefungID;
    }

    public Pruefungsleistung(int studentID, String pruefungID, int versuch, double note) {
        this.studentID = studentID;
        this.pruefungID = pruefungID;
        this.versuch = versuch;
        this.note = note;
    }

    public String getPruefungID() {
        return pruefungID;
    }

    public void setPruefungID(String pruefungID) {
        this.pruefungID = pruefungID;
    }

    public int getVersuch() {
        return versuch;
    }

    public void setVersuch(int versuch) {
        this.versuch = versuch;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Pruefungsleistung{" +
                "pruefungID='" + pruefungID + '\'' +
                ", versuch=" + versuch +
                ", note=" + note +
                ", studentID=" + studentID +
                '}';
    }
}
