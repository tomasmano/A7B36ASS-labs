/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.remote;

import java.util.Date;
import model.Person;

/**
 *
 * @author j
 */
public class PersonDS2Adapter extends Person {
    PersonDS2 person;

    public PersonDS2Adapter(PersonDS2 person) {
        this.person = person;
    }

    @Override
    public Long getId() {
        return person.getId();
    }

    @Override
    public Long getSalary() {
        return person.getSalaryYear()/12;
    }

    @Override
    public Boolean getMarried() {
        return person.getMarried();
    }

    @Override
    public String getfName() {
        return person.getfName();
    }

    @Override
    public String getlName() {
        return person.getlName();
    }

    @Override
    public Double getAge() {
        Date d = new Date(System.currentTimeMillis());
        Date pd = person.getBorn();
        return (double) (d.getYear() - pd.getYear());
    }

}
