package cz.cvut.fel.cs.jaxbrefractoring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

/**
 * Utility class for JAXB API.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class JaxbUtils {

    private static StringWriter writer = new StringWriter();

    //////////  Facade  //////////
    
    public static <T extends Serializable> String toXml(T object, Class<T> clazz) throws Exception {
        return marshall(
                new JAXBElement<T>(
                new QName(clazz.getSimpleName().toLowerCase()),
                clazz,
                object),
                clazz);
    }

    public static <T extends Serializable> T fromXml(String input, Class<T> clazz) throws Exception {
        return (T) getUnmarshaller(clazz).unmarshal(new StringReader(input));
    }

    public static <T extends Serializable> Object getValueFromXml(String input, String property, Class<T> clazz) throws Exception {
        T entity = unmarshall(input, clazz);
        return ReflexionUtils.getValue(property, entity);
    }

    public static void toFile(Object object, String filename) throws Exception {
        Marshaller m = getMarshaller(object.getClass());
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(object, new FileOutputStream(filename));
    }

    public static Object fromFile(Class clazz, String filename) throws Exception {
       return getUnmarshaller(clazz).unmarshal(new File(filename));
    }

    //////////  Helper Methods  //////////
    
    private static <T> T unmarshall(String input, Class<T> clazz) throws Exception{
        return (T) getUnmarshaller(clazz).unmarshal(new StringReader(input));
    }
    
    private static <T> String marshall(JAXBElement<T> jaxbElement, Class<T> clazz) throws Exception {
        getMarshaller(clazz).marshal(jaxbElement, writer);
        return writer.toString();
    }

    private static Marshaller getMarshaller(Class clazz) throws JAXBException {
        return getContext(clazz).createMarshaller();
    }

    private static Unmarshaller getUnmarshaller(Class clazz) throws JAXBException {
        return getContext(clazz).createUnmarshaller();
    }

    private static JAXBContext getContext(Class clazz) throws JAXBException {
        return JAXBContext.newInstance(clazz);
    }
}
