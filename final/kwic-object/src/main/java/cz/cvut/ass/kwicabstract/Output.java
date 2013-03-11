/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.ass.kwicabstract;

import java.util.Set;

/**
 *
 * @author j
 */
public class Output {

    public Output() {
    }
    
    public void printOutput(Shifter shifter) {
        //benchmarking...
        Long start = System.currentTimeMillis();
        Set<String> context = shifter.getOutput();
        if(context != null){
            for (String s : context) {
                System.out.println(s);
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("Procesed in: " + (end - start) + "ms");
    }
}