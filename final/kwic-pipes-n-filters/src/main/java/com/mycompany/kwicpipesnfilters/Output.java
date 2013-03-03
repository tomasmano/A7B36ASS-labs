/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

import j.hell.utilities.Benchmarker;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
public class Output extends Filter {

    public Output(Pipe input, Pipe output) {
        super(input, output);
    }
    
    @Override
    public void filter() {
        try {
            Long start = System.currentTimeMillis();
            while(input.isInputAvailable() != 0){
                printOutput();
            }
            Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass());
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printOutput() {
        try {
            int c = 0;
            while((c = input.readInput()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
