package cz.cvut.fel.cs.jaxbrefractoring;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ReflexionUtils {

    public static Object getValue(String property, Object object) throws Exception{
        return object
                .getClass()
                .getMethod("get"+StringUtils.capitalize(property), null)
                .invoke(object, null);
    }
}
