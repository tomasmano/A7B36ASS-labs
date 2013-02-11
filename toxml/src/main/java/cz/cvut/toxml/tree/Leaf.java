package cz.cvut.toxml.tree;

import java.lang.reflect.Field;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Leaf implements Component{
    
    private Object parent;
    private Field field;

    public Leaf(Object parent, Field field) {
        this.parent = parent;
        this.field = field;
    }
    
    public String print() throws Exception{
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(field.getName()).append(">").append(field.get(parent)).append("</").append(field.getName()).append(">");
        return builder.toString();
    }

}
