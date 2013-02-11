package cz.cvut.toxml.model;

import cz.cvut.toxml.annotation.XmlComposite;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Person extends IdEntity{

    private String name;
    private int age;
    
    @XmlComposite
    private Car car;

    public Person() {
    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public Person(Long id, String name, int age, Car car) {
        super(id);
        this.name = name;
        this.age = age;
        this.car = car;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
