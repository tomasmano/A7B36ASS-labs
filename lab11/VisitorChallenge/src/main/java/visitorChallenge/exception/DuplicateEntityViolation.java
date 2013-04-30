package visitorChallenge.exception;

import visitorChallenge.ExceptionVisitor;
import visitorChallenge.INamedEntity;


public class DuplicateEntityViolation extends BusinessException implements ExceptionElement {

    private static final long serialVersionUID = 1L;
    
    private INamedEntity duplicatedEntity;

    public DuplicateEntityViolation(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntityViolation(String message) {
        super(message);
    }

    public DuplicateEntityViolation(String message, INamedEntity duplicatedEntity) {
        super(message);
        this.duplicatedEntity = duplicatedEntity;
    }

    public DuplicateEntityViolation(INamedEntity duplicatedEntity) {
        super("Duplicate");
        this.duplicatedEntity = duplicatedEntity;
    }

    public INamedEntity getDuplicatedEntity() {
        return duplicatedEntity;
    }

    public void setDuplicatedEntity(INamedEntity duplicatedEntity) {
        this.duplicatedEntity = duplicatedEntity;
    }
    
    
    public void accept(ExceptionVisitor visitor) {
        visitor.handle(this);
    }
}
