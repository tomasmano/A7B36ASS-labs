/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.ass.kwicabstract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author j
 */
public class Input {
    private String FILE_NAME;
    private List<Line> lines = new ArrayList<Line>();

    public Input(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }
    
    /**
     * Load input file by lines.
     * @throws Exception 
     */
    public void readAndParseInputFile() throws Exception {
        try {
            // setup..
            BufferedReader buffReader = new BufferedReader(new FileReader(FILE_NAME));
            Scanner sc;
            LineNumberReader reader = new LineNumberReader(buffReader);
            String line = "";
            //benchmarking
            Long start = System.currentTimeMillis();
            //load words
            while (line != null) {
                line = reader.readLine();
                if (!StringUtils.isEmpty(line)) {
                    lines.add(new Line(reader.getLineNumber(), line));
                }
            }
            Long end = System.currentTimeMillis();
            System.out.println("Procesed in: " + (end - start) + "ms ( approx. " + (end - start) / 1000 + "s)");
        } catch (IOException e) {
            System.out.println(String.format("File [%s] not found", FILE_NAME));
            System.exit(0);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
