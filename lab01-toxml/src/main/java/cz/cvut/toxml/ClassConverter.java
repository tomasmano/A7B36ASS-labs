package cz.cvut.toxml;

import com.google.common.collect.ObjectArrays;
import cz.cvut.toxml.printer.JsonStringPrinter;
import cz.cvut.toxml.printer.XmlStringPrinter;
import cz.cvut.toxml.tree.Composite;
import cz.cvut.toxml.tree.factory.TreeFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Facade for converting a Java object to various formats.
 * 
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ClassConverter {
    
    private ClassConverter(){
        // to prevent instatiation
    }
    
    /**
     * Converts the given object to xml.
     * 
     * @param input object to convert
     * @return object converted to xml in text
     * @throws Exception 
     */
    public static String toXml(Object input) throws Exception{
        
        //retrive object's fields (as well as its inherited fields)
        Field[] allFields = retrieveFields(input);

        // set the xml root
        Composite xmlRoot = new Composite(input);
        
        // build the object tree and return converted output (XML)
        return TreeFactory.buildTree(xmlRoot, allFields, input).print(new XmlStringPrinter());
    }

    /**
     * Converts the given object to xml.
     * 
     * @param input object to convert
     * @return object converted to xml in text
     * @throws Exception 
     */
    public static String toJson(Object input) throws Exception{
        
        //retrive object's fields (as well as its inherited fields)
        Field[] allFields = retrieveFields(input);

        // set the xml root
        Composite xmlRoot = new Composite(input);
        
        // build the object tree and return converted output (XML)
        return TreeFactory.buildTree(xmlRoot, allFields, input).print(new JsonStringPrinter());
    }
    
    /**
     * Retrievev object's fields (as well as its inherited fields)
     * 
     * @param intput object which fields to retrieve
     * @return retrieved object's fields
     */
    private static Field[] retrieveFields(Object input) {
        Field[] fields = input.getClass().getDeclaredFields();
        Field[] inheritedFields = getFieldsFromSuperClass(new ArrayList<Field>(), input);
        Field[] allFields = ObjectArrays.concat(fields, inheritedFields, Field.class);
        return allFields;
    }
    
    /**
     * Get inherited fields from class.
     * 
     * @param inherited
     * @param input
     * @return 
     */
    private static synchronized Field[] getFieldsFromSuperClass(List<Field> inherited, Object input){
        Class clazz = (Class) input.getClass().getSuperclass();
        if (clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                inherited.add(field);
            }
            // recursion..
            getFieldsFromSuperClass(inherited, clazz);
        }
        return inherited.toArray(new Field[inherited.size()]);
    }
}
