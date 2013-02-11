package cz.cvut.toxml.tree.builder;

import cz.cvut.toxml.annotation.XmlComposite;
import cz.cvut.toxml.tree.Composite;
import cz.cvut.toxml.tree.Leaf;
import java.lang.reflect.Field;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class TreeBuilder {

    public TreeBuilder() {
    }

    /**
     * Populate the given tree with the given fields on the specified object.
     *
     * @param root the tree to populate
     * @param fields the given fields
     * @param marshalled specified object
     * @throws Exception
     */
    public Composite buildTree(Composite root, Field[] fields, Object marshalled) throws Exception {
        for (Field field : fields) {

            field.setAccessible(true);

            // is it a composite?
            if (field.isAnnotationPresent(XmlComposite.class)) {
                Object newMarshaled = field.get(marshalled);
                Composite newRoot = new Composite(newMarshaled);
                root.add(newRoot);
                // recursion....
                buildTree(newRoot, newMarshaled.getClass().getDeclaredFields(), newMarshaled);
            } 
            // or is it a leaf?
            else {
                root.add(new Leaf(marshalled, field));
            }

        }
        return root;
    }
}
