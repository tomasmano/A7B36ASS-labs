/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.remote;

import model.Person;

/**
 *
 * @author j
 */
public class PersonDS1Adapter extends Person{
    PersonDS1 person;

    public PersonDS1Adapter(PersonDS1 person) {
        this.person = person;
    }

    @Override
    public Long getId() {
            return person.getId();
    }

    @Override
    public Long getSalary() {
            return person.getSalary();
    }

    @Override
    public Boolean getMarried() {
            return person.getPartner() != null;
    }

    @Override
    public String getfName() {
            return person.getName().split(" ")[0];
    }

    @Override
    public String getlName() {
            return person.getName().split(" ")[1];
    }

    @Override
    public Double getAge() {
            return person.getAge();
    }

}
