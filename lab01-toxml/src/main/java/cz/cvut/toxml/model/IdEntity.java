package cz.cvut.toxml.model;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class IdEntity {
    
    private Long id;

    public IdEntity() {
    }

    public IdEntity(Long id) {
        this.id = id;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
