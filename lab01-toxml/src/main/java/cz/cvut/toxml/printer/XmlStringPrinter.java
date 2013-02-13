package cz.cvut.toxml.printer;

import cz.cvut.toxml.tree.Component;
import cz.cvut.toxml.tree.Composite;
import cz.cvut.toxml.tree.Leaf;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class XmlStringPrinter implements Printer<String> {

    public String print(Composite composite) throws Exception {
        StringBuilder builder = new StringBuilder();
        String rootName = composite.getParent().getClass().getSimpleName();
        builder.append("<").append(rootName).append(">").append("\n");
        for (Component component : composite.getLeafs()) {
            builder.append(component.print(this));
        }
        builder.append("</").append(rootName).append(">").append("\n");
        return builder.toString();
    }

    public String print(Leaf leaf) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(leaf.getField().getName()).append(">").append(leaf.getField().get(leaf.getParent())).append("</").append(leaf.getField().getName()).append(">").append("\n");
        return builder.toString();
    }
}
