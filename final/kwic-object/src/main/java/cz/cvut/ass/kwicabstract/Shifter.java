/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.ass.kwicabstract;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author j
 */
public class Shifter {
    private Set<String> output = new TreeSet<String>();

    public Shifter() {
    }
    
    /**
     * Cirular permutation of word on each line.
     * Alphabetization done automatically by TreeSet.
     */
    public void circularShiftAndAlphabetization(Input input){
         //benchmarking
        Long start = System.currentTimeMillis();
        StringBuilder sb;
        List<Line> lines = input.getLines();
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
                    output.add(sb.toString());
                }
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("Procesed in: " + (end - start) + "ms ( approx. " + (end - start) / 1000 + "s)");
    }

    public Set<String> getOutput() {
        return output;
    }
    
}
