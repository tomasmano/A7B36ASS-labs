/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicobject;

import java.util.List;
import java.util.Set;

/**
 *
 * @author j
 */
public class Output {
    private Alphabetizer alphabetizer;

    public Output(Alphabetizer alphabetizer) {
        this.alphabetizer = alphabetizer;
    }
    
    public void printOutput(String inputKeyWord, Dictionary<String, List<Integer>> dict, Shifter shifter) throws Exception {
        List<Integer> numLines = dict.get(inputKeyWord);
        if (numLines == null) {
            System.out.println(String.format("Word [%s] not found..", inputKeyWord));
            return;
        }
        System.out.println("Occurence on lines [Number of times: " + numLines.size() + "x]: " + numLines);
        System.out.println("Word '" + inputKeyWord + "' is appearing in these contexts: \n");
        Long start = System.currentTimeMillis();

        Set<String> context = alphabetizer.getContext();
        
        for (String s : context) {
            System.out.println(s);
        }
        
        Long end = System.currentTimeMillis();
        System.out.println("Procesed in: " + (end - start) + "ms");
//        for (String out : res) {
//            System.out.println(out);
//        }
    }
}
