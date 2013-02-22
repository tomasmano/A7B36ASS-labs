package cz.cvut.toxml.tree;

import cz.cvut.toxml.printer.Printer;
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
    
    public <E> E print(Printer<E> printer) throws Exception{
        return printer.print(this);
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

}
