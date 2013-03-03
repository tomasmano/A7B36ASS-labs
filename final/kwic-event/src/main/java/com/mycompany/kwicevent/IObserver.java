/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicevent;

/**
 *
 * @author j
 */
public interface IObserver<E>{
        
    /**
     * 
     * @param o
     */
    public void update(IObservable<E> o);
}
