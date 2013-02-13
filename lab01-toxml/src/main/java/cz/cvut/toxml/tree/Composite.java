package cz.cvut.toxml.tree;

import cz.cvut.toxml.printer.Printer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Composite implements Component{
    
    private Object parent;
    
    private List<Component> leafs = new ArrayList<Component>();
    
    public Composite(Object parent) {
        this.parent = parent;
    }

    public <E> E print(Printer<E> printer) throws Exception{
        return printer.print(this);
    }
    
    public void add(Component c){
        leafs.add(c);
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public List<Component> getLeafs() {
        return leafs;
    }

    public void setLeafs(List<Component> leafs) {
        this.leafs = leafs;
    }
    
}
