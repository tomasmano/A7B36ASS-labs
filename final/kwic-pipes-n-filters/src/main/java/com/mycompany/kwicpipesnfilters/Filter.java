/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
abstract public class Filter implements Runnable{
    protected Pipe input;
    protected Pipe output;

    public Filter(Pipe input, Pipe output) {
        this.input = input;
        this.output = output;
    }

    /**
     * starts new thread
     */
    public void start(){
        new Thread(this).start();
    }

    /**
     * executes new thread
     */
    @Override
    public void run() {
        filter();
    }

    /**
     * filters the data, depends on ancestors own implementation
     */
    abstract public void filter();

    @SuppressWarnings("empty-statement")
    protected void waitForAssembly(){
        if(input != null)
            input.isInputAvailable();
    }
}
