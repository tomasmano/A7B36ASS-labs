/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicevent;

import j.hell.utilities.Benchmarker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author j
 */
public class Input extends Observable<Line> {
    private String FILE_NAME;

    public Input(String FILE_NAME) {
        super(new ArrayList<Line>());
        this.FILE_NAME = FILE_NAME;
    }
    
    /**
     * Load input file by lines.
     * @throws Exception 
     */
    public void readAndParseInputFile() {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(FILE_NAME));
            LineNumberReader reader = new LineNumberReader(buffReader);
            String line = "";
            Long start = System.currentTimeMillis();
            while (line != null) {
                line = reader.readLine();
                if (!StringUtils.isEmpty(line)) {
                    result.add(new Line(reader.getLineNumber(), line));
                }
            }
            Benchmarker.saveBenchmark(System.currentTimeMillis() - start, this.getClass().getSimpleName(), this.getClass());
        } catch (IOException e) {
            System.out.println(String.format("File [%s] not found", FILE_NAME));
            System.exit(0);
        }
        notifyObservers();
    }


}
