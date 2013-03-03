/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicevent;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author j
 */
public abstract class Observable<E> implements IObservable<E> {
    Collection<IObserver> observers = new HashSet<>();
    Collection<E> result;

    public Observable(Collection<E> result) {
        this.result = result;
    }

    @Override
    public Collection<E> getResult(){
        return result;
    }
    
    @Override
    public void notifyObservers(){
        for (IObserver o : observers) {
            o.update(this);            
        }
    }

    @Override
    public void addObserver(IObserver o) {
        if(!observers.contains(o))
            observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        if(observers.contains(o))
            observers.remove(o);
    }
    
    
}
