/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicpipesnfilters;

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
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * executes new thread
     */
    @Override
    public void run() {
        filter();
    }

    /**
     * filters the data, dempends on ancestors own implementation
     */
    abstract public void filter();

}
