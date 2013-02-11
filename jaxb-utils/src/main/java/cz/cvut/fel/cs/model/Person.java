package cz.cvut.fel.cs.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Person implements Serializable {

    private static final int DEFAULT_AGE = 20;
    private String fName;
    private String lName;
    private Integer age;
    private String note;
    private Set<Car> carSet = new HashSet<Car>();

    public Person() {
        super();
        age = DEFAULT_AGE;
    }

    public Person(String fName, String lName, Integer age, String note,
            Set<Car> carSet) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.note = note;
        this.carSet = carSet;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.fName != null ? this.fName.hashCode() : 0);
        hash = 59 * hash + (this.lName != null ? this.lName.hashCode() : 0);
        hash = 59 * hash + (this.age != null ? this.age.hashCode() : 0);
        hash = 59 * hash + (this.note != null ? this.note.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.fName == null) ? (other.fName != null) : !this.fName.equals(other.fName)) {
            return false;
        }
        if ((this.lName == null) ? (other.lName != null) : !this.lName.equals(other.lName)) {
            return false;
        }
        if (this.age != other.age && (this.age == null || !this.age.equals(other.age))) {
            return false;
        }
        if ((this.note == null) ? (other.note != null) : !this.note.equals(other.note)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "fName=" + fName + ", lName=" + lName + ", age=" + age + ", note=" + note + ", carSet=" + carSet + '}';
    }
}
