package cz.cvut.toxml.tree;

import cz.cvut.toxml.printer.Printer;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface Component {

    public <E> E print(Printer<E> printer) throws Exception;
}
