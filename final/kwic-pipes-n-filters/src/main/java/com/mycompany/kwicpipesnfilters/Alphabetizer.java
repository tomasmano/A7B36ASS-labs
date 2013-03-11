/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

import j.hell.utilities.Benchmarker;
import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
public class Alphabetizer extends Filter {
    Collection<String> lines = new TreeSet<>();

    public Alphabetizer(Pipe input, Pipe output) {
        super(input, output);
    }
    
    @Override
    public void filter() {
        try {
            Long start = System.currentTimeMillis();
            waitForAssembly();
            while(input.isInputAvailable()) {
                parse();
                forwardOutput();
                lines.clear();
            }
            Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass());
            output.closeOutput();
        } catch (IOException ex) {
            Logger.getLogger(Alphabetizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void parse() {
        try {
            boolean newLine = true, counterSet = false;
            StringBuilder sb = new StringBuilder();
            int c = 0, counter = 0;
            while((c = input.readInput()) != -1){
                switch(c) {
                    case ' ' : if(newLine) break;
                        else {
                            if(!counterSet) ++counter;
                            sb.append((char) c);
                        }
                        break;
                    case '\n' : if(!newLine){
                            lines.add(sb.append((char) c).toString().toLowerCase());
                            sb = new StringBuilder();
                            newLine = true;
                            if(!counterSet) {
                                counterSet = true;
                                --counter;
                                break;
                            }
                            if(counterSet) --counter;
                            if(counterSet && counter == 0){
                                return;
                            }
                        }
                        break;
                    default : sb.append((char) c);
                        newLine = false;
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CircularShifter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void forwardOutput() throws IOException {
        for (String s : lines) {
            for (byte b : s.getBytes()) {
                output.writeOutput((int) b);
            }
        }
    }
    
}
