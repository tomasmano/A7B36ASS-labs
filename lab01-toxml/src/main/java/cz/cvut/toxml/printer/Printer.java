package cz.cvut.toxml.printer;

import cz.cvut.toxml.tree.Composite;
import cz.cvut.toxml.tree.Leaf;

/**
 * Print contract.
 * 
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface Printer<E> {

    public E print(Composite composite) throws Exception;

    public E print(Leaf leaf) throws Exception;
}
