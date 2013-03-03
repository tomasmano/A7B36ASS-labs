/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicevent;

import j.hell.utilities.Benchmarker;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author j
 */
public class Shifter extends Observable<String> implements IObserver<Line> {
    private Collection<Line> lines;

    public Shifter() {
        super(new TreeSet<String>());
    }
    
    /**
     * Cirular permutation of word on each line.
     * Alphabetization done automatically by TreeSet.
     */
    public void circularShiftAndAlphabetization(){
         //benchmarking
        Long start = System.currentTimeMillis();
        StringBuilder sb;
        if(lines != null){
            for (Line l : lines) {
                String[] arr = l.getWords();
                for (int i = 0; i < arr.length; i++) {
                    sb = new StringBuilder();
                    String first = arr[0];
                    for (int j = 0; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                        sb.append(arr[j]).append(" ");
                    }
                    arr[arr.length -1] = first;
                    sb.append(first);
                    result.add(sb.toString());
                }
            }
        }
        Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass().getSimpleName(), this.getClass());
        notifyObservers();
    }

    @Override
    public void update(IObservable<Line> o) {
        lines = o.getResult();
        circularShiftAndAlphabetization();
    }
    
}
