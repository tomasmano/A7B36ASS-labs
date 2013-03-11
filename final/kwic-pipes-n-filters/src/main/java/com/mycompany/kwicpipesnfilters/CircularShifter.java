/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

import j.hell.utilities.Benchmarker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
public class CircularShifter extends Filter {
    List<String> words = new ArrayList<>();

    public CircularShifter(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    public void filter() {
        try {
            Long start = System.currentTimeMillis();
            waitForAssembly();
            while(input.isInputAvailable()){
                parse();
                createShifts();
                words.clear();
            }
            Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass());
            output.closeOutput();
        } catch (IOException ex) {
            Logger.getLogger(CircularShifter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * parses input bytes into words separated by space, and determines new lines
     */
    private void parse() {
        try {
            int offset = 0;
            byte[] arr = new byte[46];
            int c = 0;
            while((c = input.readInput()) != -1){
                if(c == ' ' || c == '\n'){
                    words.add(new String(arr, 0, offset));
                    offset = 0;
                    if(c == '\n')
                        return;                
                }
                else 
                    arr[offset++] = (byte) c;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(CircularShifter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * creates word permutations
     */
    private void createShifts() {
        String[] arr = new String[words.size()];
        arr = words.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            String first = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = first;
            forwardOutput(arr);
        }
    }

    /**
     * forward filtered data to output pipe
     * @param arr 
     */
    private void forwardOutput(String[] arr) {
        try {
            for (String s : arr) {
                for (byte b : s.getBytes()) {
                    output.writeOutput((int) b);
                }
                output.writeOutput(' ');
            }
            output.writeOutput('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(CircularShifter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
