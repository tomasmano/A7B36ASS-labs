package cz.cvut.fel.cs.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Car implements Serializable {

    private String znacka;
    private String barva;
    private List<Person> personList = new ArrayList<Person>();

    public Car() {
        super();
    }

    public Car(String znacka, String barva) {
        super();
        this.znacka = znacka;
        this.barva = barva;
    }

    public String getPlate() {
        return znacka;
    }

    public void setPlate(String znacka) {
        this.znacka = znacka;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Car{" + "znacka=" + znacka + ", barva=" + barva + ", personList=" + personList + '}';
    }
}
