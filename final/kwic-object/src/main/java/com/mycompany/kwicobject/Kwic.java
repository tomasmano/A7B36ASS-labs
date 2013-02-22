/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicobject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author j
 */

public class Kwic {
    private String FILE_NAME;
    private List<Line> lines = new ArrayList<Line>();
    private Set<String> output = new TreeSet<String>();

    public Kwic(String FILE_NAME) {
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
    
    /**
     * Cirular permutation of word on each line.
     * Alphabetization done automatically by TreeSet.
     */
    public void circularShiftAndAlphabetization(){
         //benchmarking
        Long start = System.currentTimeMillis();
        StringBuilder sb;
        for (Line l : lines) {
            String[] arr = l.getWords();
            for (int i = 0; i < arr.length; i++) {
                sb = new StringBuilder();
                String first = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                    sb.append(arr[j]).append(" ");
                }
                arr[arr.length -1] = first;
                sb.append(first);
                output.add(sb.toString());
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("Procesed in: " + (end - start) + "ms ( approx. " + (end - start) / 1000 + "s)");
    }
    
    /**
     * Simple output, where indexed key is the first word in line.
     */
    public void outputAndPrint(){
        System.out.println("KWIC for file : " + FILE_NAME);
        
        for (String s : output) {
            System.out.println(s);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Kwic k = new Kwic("input.txt");
        k.readAndParseInputFile();
        k.circularShiftAndAlphabetization();
        k.outputAndPrint();
    }
}
