package visitorChallenge;

import visitorChallenge.exception.AuthorizationException;
import visitorChallenge.exception.BusinessRuleViolation;
import visitorChallenge.exception.DuplicateEntityViolation;
import visitorChallenge.exception.SearchException;
import visitorChallenge.exception.SystemError;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ExceptionVisitor {

    public void handle(AuthorizationException e) {
        System.err.println(e.getErrorName() + " " + e.getType());
        e.printStackTrace();
    }

    public void handle(BusinessRuleViolation e) {
        System.err.println(e.getErrorName() + " " + e.getBusinessRuleViolated() + " " + e.getCauser().getClass().getSimpleName());
        e.printStackTrace();
    }

    public void handle(DuplicateEntityViolation e) {
        System.err.println(e.getErrorName() + " " + e.getDuplicatedEntity().getName());
        e.printStackTrace();
    }

    public void handle(SearchException e) {
        System.err.println(e.getErrorName() + " " + e.getMessage());
        e.printStackTrace();
    }

    public void handle(SystemError e) {
        System.err.println("Unexpected error " + e.getErrorName() + " " + e.getType());
        e.printStackTrace();
    }
}
