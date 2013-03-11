/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.remote;

import java.util.Date;
import model.IPerson;

/**
 *
 * @author j
 */
public class PersonDS2ClassAdapter extends PersonDS2 implements IPerson {

    public PersonDS2ClassAdapter() {
        super();
    }
    

    @Override
    public Double getAge() {
        Date d = new Date(System.currentTimeMillis());
        Date pd = getBorn();
        return (double) (d.getYear() - pd.getYear());
    }

    @Override
    public Long getSalary() {
        return getSalaryYear()/12;
    }
    
}
