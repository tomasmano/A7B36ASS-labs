package cz.cvut.fel.cs.jaxbrefractoring;

import cz.cvut.fel.cs.model.Car;
import cz.cvut.fel.cs.model.Person;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception{
        // set up testing objects
        Set<Car> car = new HashSet<Car>();
        car.add(new Car("AAA2343", "red"));
        car.add(new Car("BBB2343", "blue"));
        Person person = new Person("Tom", "Cerny", 12, "", car);
        
        
        // test...
        
        // testing output object to xml string
        String output = JaxbUtils.toXml(person, Person.class);
        System.out.println(output);
        
        // testing convert xml string to Java object
        Person retrieved = JaxbUtils.fromXml(output, Person.class);
        System.out.println("Are equal? ->" +person.equals(retrieved));
        System.out.println("Retrireved person's from xml: "+retrieved);
        
        // testing extracting object's property value from xml
        Object value = JaxbUtils.getValueFromXml(output, "age", Person.class);
        System.out.println("Retrireved person's age from xml: "+value);
        
        // testing reading and writing xml to file
        JaxbUtils.toFile(person, "test.xml");
        Person fromFile = (Person) JaxbUtils.fromFile(Person.class, "test.xml");
        System.out.println("Retreived person from file: "+fromFile);
        
    }
}
