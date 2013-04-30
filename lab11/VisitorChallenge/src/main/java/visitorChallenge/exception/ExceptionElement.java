package visitorChallenge.exception;

import visitorChallenge.ExceptionVisitor;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface ExceptionElement {

    void accept(ExceptionVisitor visitor);
}
