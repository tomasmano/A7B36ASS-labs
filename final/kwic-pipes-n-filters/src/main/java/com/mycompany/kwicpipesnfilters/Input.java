/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

import j.hell.utilities.Benchmarker;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
public class Input extends Filter {
    private InputStream in;    
    private boolean newLine = true;

    public Input(InputStream in, Pipe output) {
        super(null, output);
        this.in = in;
    }
    
    @Override
    public void filter() {
        waitForAssembly();
        try {
            Long start = System.currentTimeMillis();
            int c;
            while((c = in.read()) != -1){
                if((c > 64 && c < 91) || (c > 96 && c < 123) || c == ' ' || c == '\n' || c == '\t'){
                    switch(c) {
                        case '\n' : if(newLine)
                                        break;
                            output.writeOutput((byte) c);
                            newLine = true;
                            break;
                        case '\t' : output.writeOutput(' ');
                            break;
                        case '\r' : break;
                        case ';' : break;
                        default : output.writeOutput((byte) c);
                            newLine = false;
                            break;
                    }
                }
            }
            output.writeOutput('\n');
            Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass());
            in.close();
            output.closeOutput();
        } catch (IOException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
