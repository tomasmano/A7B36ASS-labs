package cz.cvut.toxml;

import cz.cvut.toxml.model.Car;
import cz.cvut.toxml.model.Person;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * Testing convertion for Person class to xml.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // example class
        Person person = new Person(999L, "tomy", 26, new Car("abc123", "pink"));
        
        // do conversion
        String output = ClassToXmlConverter.toXml(person);

        // print to console for testing
        System.out.println(output);
    }

}
