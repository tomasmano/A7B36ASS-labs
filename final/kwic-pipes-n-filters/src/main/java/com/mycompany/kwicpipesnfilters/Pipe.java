/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
public class Pipe {
    private PipedInputStream input;
    private PipedOutputStream output;

    public Pipe() throws IOException {
        input = new PipedInputStream();
        output = new PipedOutputStream();
        output.connect(input);
    }
       
    public void closeInput() throws IOException {
        input.close();
    }
    
    public void closeOutput() throws IOException {
        output.flush();
        output.close();
    }
    
    public int readInput() throws IOException {
        return input.read();
    }
    
    public void writeOutput(int b) throws IOException {
        output.write(b);
    }
    
    public boolean isInputAvailable() {
        try {
            return input.available() != 0;
        } catch (IOException ex) {
            Logger.getLogger(Pipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
}
