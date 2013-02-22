/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicobject;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author j
 */
public class Alphabetizer {
    private Set<String> context;
    private Shifter shifter;

    public Alphabetizer(Shifter shifter) {
        this.shifter = shifter;
    }
    
    public Set<String> getAlphabetisizedContext(){
        List<String> circular = shifter.getContexts();
        
        context = new TreeSet<String>(circular);
        
        return context;
    }

    public Set<String> getContext() {
        return context;
    }
    
    
}
