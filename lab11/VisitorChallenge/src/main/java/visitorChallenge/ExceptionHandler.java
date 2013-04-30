package visitorChallenge;

import visitorChallenge.exception.AuthorizationException;
import visitorChallenge.exception.BusinessRuleViolation;
import visitorChallenge.exception.DuplicateEntityViolation;
import visitorChallenge.exception.ExceptionElement;
import visitorChallenge.exception.SearchException;
import visitorChallenge.exception.SystemError;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ExceptionHandler {

    private ExceptionVisitor visitor = new ExceptionVisitor();

    public static void handle(Exception e) {
        if (e instanceof ExceptionElement) {
            ExceptionElement ee = (ExceptionElement) e;
            ee.accept(new ExceptionVisitor());
        }
    }

    public static void handle(ExceptionElement e) {
        e.accept(new ExceptionVisitor());
    }

    public void handle(AuthorizationException e) {
        e.accept(visitor);
    }

    public void handle(BusinessRuleViolation e) {
        e.accept(visitor);
    }

    public void handle(DuplicateEntityViolation e) {
        e.accept(visitor);
    }

    public void handle(SearchException e) {
        e.accept(visitor);
    }

    public void handle(SystemError e) {
        e.accept(visitor);
    }
}
