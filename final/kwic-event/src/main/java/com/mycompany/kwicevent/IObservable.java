/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicevent;

import java.util.Collection;

/**
 *
 * @author j
 */
public interface IObservable<E> {
    
    /**
     * Lets all observers know, that an event occured.
     */
    public void notifyObservers();
    
    /**
     * Returns result of an operation.
     * @return
     */
    public Collection<E> getResult();
    
    /**
     * Register new observer.
     * @param o 
     */
    public void addObserver(IObserver o);
    
    /**
     * Unregister an observer.
     * @param o 
     */
    public void removeObserver(IObserver o);
}
