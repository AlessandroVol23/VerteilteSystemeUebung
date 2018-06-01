package de.oth.vs.rest;

import de.oth.vs.entity.Adresse;
import de.oth.vs.entity.Student;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Path("studienangelegenheiten")
public class StudentResource {

    @Path("student/{id}")
    @GET
    public Student getStudentById(@PathParam("id") int id) {

        Student s = new Student(1, "Sandro", "Volpicella", 128, new Adresse("Rosenstrasse 80", "Taufkirchen"));
        System.out.println("de.oth.vs.rest.StudentResource.getStudentById(): Erstelle Student...");
        //Student ret = Student.getStudentById(id);
        System.err.println("de.oth.vs.rest.StudentResource.getStudentById(): Name von Student ist: " + s.getVorname() + " " + s.getNachname());

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Student.class);
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxbMarshaller.marshal(s, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(StudentResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    @Path("student/{id}")
    @DELETE
    public void deleteStudentById(@PathParam("id") int id) {

    }

    @Path("student/{from}/{to}")
    @GET
    public void getStudentsByIdRange(@PathParam("from") int from,
            @PathParam("to") int to) {

    }

}
