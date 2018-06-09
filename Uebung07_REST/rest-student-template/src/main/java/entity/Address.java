package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    private String street;
    private String zipCode;
    private String city;

    public Address() {

    }

    public Address(String _street, String _city) {
        this.street = _street;
        this.city = _city;
    }

    public Address(String _street, String _zipCode, String _city) {
        this.street = _street;
        this.zipCode = _zipCode;
        this.city = _city;
    }


}
