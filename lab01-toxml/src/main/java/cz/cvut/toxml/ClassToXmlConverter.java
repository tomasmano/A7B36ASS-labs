package cz.cvut.toxml;

import com.google.common.collect.ObjectArrays;
import cz.cvut.toxml.tree.Composite;
import cz.cvut.toxml.tree.builder.TreeBuilder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Facade for converting a Java object to xml.
 * 
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ClassToXmlConverter {
    
    private ClassToXmlConverter(){
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
        Field[] fields = input.getClass().getDeclaredFields();
        Field[] inheritedFields = getFieldsFromSuperClass(new ArrayList<Field>(), input);
        Field[] allFields = ObjectArrays.concat(fields, inheritedFields, Field.class);

        // set the xml root
        Composite xmlRoot = new Composite(input);

        // prepare the builder instance
        TreeBuilder builder = new TreeBuilder();
        
        // build the object tree and return converted output (XML)
        return builder.buildTree(xmlRoot, allFields, input).print();
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
