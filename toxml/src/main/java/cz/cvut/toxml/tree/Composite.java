package cz.cvut.toxml.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Composite implements Component{
    
    private Object parent;
    
    public Composite(Object parent) {
        this.parent = parent;
    }

    private List<Component> leafs = new ArrayList<Component>();

    public String print() throws Exception{
        StringBuilder builder = new StringBuilder();
        String rootName = parent.getClass().getSimpleName();
        builder.append("<").append(rootName).append(">");
        for (Component component : leafs) {
            builder.append(component.print());
        }
        builder.append("</").append(rootName).append(">");
        return builder.toString();
    }
    
    public void add(Component c){
        leafs.add(c);
    }
}
