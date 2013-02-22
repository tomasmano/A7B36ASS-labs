package cz.cvut.fel.cs.jaxbrefractoring;

import cz.cvut.fel.cs.model.Car;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;

import cz.cvut.fel.cs.model.Person;

public class SerializerJAXB {

	private static final String PERSON_XML = "person.xml";

	public static void main(String[] args) throws Exception {
		Set<Car> car = new HashSet<Car>();
		car.add(new Car("AAA2343", "red"));
		car.add(new Car("BBB2343", "blue"));
		Person person = new Person("Tom", "Cerny", 12, "", car);

		JAXBContext context = JAXBContext.newInstance(Person.class);
		StringWriter writer = new StringWriter();
		JAXBElement<Person> jaxbElementA = 
                        new JAXBElement<Person>(
                        new QName("person"), 
                        Person.class, 
                        person);
		
		Marshaller m = context.createMarshaller();
		m.marshal(jaxbElementA, writer);
		System.out.println(writer.toString());
		
		
		JAXBSource sourceA = new JAXBSource(context, jaxbElementA);

		JAXBContext contextB = JAXBContext.newInstance(Person.class);
		Unmarshaller unmarshallerB = contextB.createUnmarshaller();
		JAXBElement<Person> jaxbElementB = unmarshallerB.unmarshal(sourceA,
				Person.class);

		Person personDes = jaxbElementB.getValue();
		// TODO refactor
		System.out.println("#1 "+ personDes.getlName());
		System.out.println("#2 " +personDes.getCarSet().iterator().next().getPlate());

		// to a file
		//JAXBContext context = JAXBContext.newInstance(Person.class);
		//Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(person, new FileOutputStream("result.xml"));

		// from a file
		try {
			JAXBContext context1 = JAXBContext.newInstance(Person.class);
			Unmarshaller u = context1.createUnmarshaller();

			Person personDes2 = (Person) u.unmarshal(new File("result.xml"));
			// TODO refactor
			System.out.println(personDes2.getlName());
			System.out.println(personDes2.getCarSet().iterator().next()
					.getPlate());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
