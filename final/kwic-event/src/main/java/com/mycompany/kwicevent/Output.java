/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicevent;

import j.hell.utilities.Benchmarker;
import java.util.Collection;

/**
 *
 * @author j
 */
public class Output implements IObserver<String>{
    private Collection<String> context;

    public Output() {
    }
    
    public void printOutput() {
        Long start = System.currentTimeMillis();
        if(context != null){
            for (String s : context) {
                System.out.println(s);
            }
        }
        Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass().getSimpleName(), this.getClass());
    }

    @Override
    public void update(IObservable<String> o) {
        context = o.getResult();
    }

}
