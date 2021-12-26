package co.com.sofka.model;

import co.com.sofka.util.State;
import co.com.sofka.util.City;

public class ZonaFitModel {
    private String documentNumber;
    private String email;
    private String name;
    private String lastName;
    private State state;
    private City city;
    private String address;
    private String complementaryAddress;
    private String cellPhone;
    private String note;

    public String getDocumentNumber () {
        return documentNumber;
    }

    public void setDocumentNumber (String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public State getState () {
        return state;
    }

    public void setState (State state) {
        this.state = state;
    }

    public City getCity () {
        return city;
    }

    public void setCity (City city) {
        this.city = city;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getComplementaryAddress () {
        return complementaryAddress;
    }

    public void setComplementaryAddress (String complementaryAddress) {
        this.complementaryAddress = complementaryAddress;
    }

    public String getCellPhone () {
        return cellPhone;
    }

    public void setCellPhone (String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getNote () {
        return note;
    }

    public void setNote (String note) {
        this.note = note;
    }
}
