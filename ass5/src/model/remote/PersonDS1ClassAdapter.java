/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.remote;

import model.IPerson;

/**
 *
 * @author j
 */
public class PersonDS1ClassAdapter extends PersonDS1 implements IPerson {

    public PersonDS1ClassAdapter() {
        super();
    }

    @Override
    public Boolean getMarried() {
        return getPartner() != null;
    }

    @Override
    public String getfName() {
        return getName().split(" ")[0];
    }

    @Override
    public String getlName() {
        return getName().split(" ")[1];
    }
    
}
