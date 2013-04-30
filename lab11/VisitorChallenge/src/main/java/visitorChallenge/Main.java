package visitorChallenge;

import visitorChallenge.exception.AuthorizationException;
import visitorChallenge.exception.BusinessRuleViolation;
import visitorChallenge.exception.DuplicateEntityViolation;
import visitorChallenge.exception.SearchException;
import visitorChallenge.exception.SystemError;
import visitorChallenge.exception.AuthorizationException.Type;
import visitorChallenge.exception.BusinessRuleViolation.BusinessRule;
import visitorChallenge.exception.ExceptionElement;

public class Main {

    public static void madMethod() throws AuthorizationException, BusinessRuleViolation, DuplicateEntityViolation, SearchException, SystemError {
        double seed = Math.random();
        if (seed < 0.15) {
            throw new AuthorizationException(Type.ACCESS_DENIED, new Exception("User crab not allowed"));
        } else if (seed < 0.3) {
            throw new DuplicateEntityViolation("Duplicate issue", new NamedEntity());
        } else if (seed < 0.45) {
            throw new BusinessRuleViolation("Holy crab", BusinessRule.FEE_TOO_SMALL, new NamedEntity());
        } else if (seed < 0.6) {
            throw new SearchException("Holy moly query");
        } else if (seed < 0.75) {
            throw new SystemError("Gosh", new Exception("Crab error"), visitorChallenge.exception.SystemError.Type.TRANSIENT_INSTANCE);
        }
        System.out.println("Yupee");
    }

    /**
     * Can I simplify this somehow via Visitor?
     *
     * You can expect only there exceptions to show up
     *
     * @param args
     */
//	public static void main(String[] args) {
//		try {
//			madMethod();
//		} catch (AuthorizationException e) {
//			System.err.println(e.getErrorName() + " " + e.getType());
//			e.printStackTrace();
//		} catch (BusinessRuleViolation e) {
//			System.err.println(e.getErrorName() + " " + e.getBusinessRuleViolated() + " " + e.getCauser().getClass().getSimpleName());
//			e.printStackTrace();
//		} catch (DuplicateEntityViolation e) {
//                            System.err.println(e.getErrorName() + " " + e.getDuplicatedEntity().getName());
//                            e.printStackTrace();
//		} catch (SearchException e) {
//			System.err.println(e.getErrorName() + " " + e.getMessage());
//			e.printStackTrace();
//		} catch (SystemError e) {
//			System.err.println("Unexpected error" + e.getErrorName() + " " + e.getType());
//			e.printStackTrace();
//		}
//	}
    public static void main(String[] args) {
        try {
            madMethod();
        } catch (Exception e) {
            ExceptionHandler.handle((ExceptionElement) e);
        }
    }
}
