package cz.cvut.toxml.tree;

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

    public String print() throws Exception{
        StringBuilder builder = new StringBuilder();
        String rootName = parent.getClass().getSimpleName();
        builder.append("<").append(rootName).append(">").append("\n");
        for (Component component : leafs) {
            builder.append(component.print());
        }
        builder.append("</").append(rootName).append(">").append("\n");
        return builder.toString();
    }
    
    public void add(Component c){
        leafs.add(c);
    }
}
