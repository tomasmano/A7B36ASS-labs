package cz.cvut.toxml;

import cz.cvut.toxml.annotation.XmlCompostie;
import cz.cvut.toxml.model.Car;
import cz.cvut.toxml.model.Person;
import cz.cvut.toxml.tree.Composite;
import cz.cvut.toxml.tree.Leaf;
import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        Person person = new Person("tomy", 26, new Car("abc123", "pink"));
        Composite root = new Composite(person);

        Class clazz = person.getClass();
        Field[] fields = clazz.getDeclaredFields();
        populateTree(root, fields, person);
        System.out.println(root.print());
    }

    public static void populateTree(Composite root, Field[] fields, Object marshalled) throws Exception{
        for (Field field : fields) {
            
            field.setAccessible(true);
            
            // is composite?
            if (field.isAnnotationPresent(XmlCompostie.class)) {
                Object newMarshaled = field.get(marshalled);
                Composite newRoot = new Composite(newMarshaled);
                root.add(newRoot);
                populateTree(newRoot, newMarshaled.getClass().getDeclaredFields(), newMarshaled);
            } 
            // or is simple element?
            else {
                root.add(new Leaf(marshalled, field));
            }

        }
    }
}
