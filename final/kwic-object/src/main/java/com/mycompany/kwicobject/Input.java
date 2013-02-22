/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicobject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;


/**
 *
 * @author j
 */
public class Input {
    private final String FILE_NAME;
    private Dictionary<String, List<Integer>> dict;

    public Input(String FILE_NAME, Dictionary<String, List<Integer>> dict) {
        this.FILE_NAME = FILE_NAME;
        this.dict = dict;
    }

    public void readText() throws Exception {
        try {
            // setup..
            BufferedReader buffReader = new BufferedReader(new FileReader(FILE_NAME));
            Scanner sc;
            LineNumberReader reader = new LineNumberReader(buffReader);
            String line = "";

            Long start = System.currentTimeMillis();
            // and loop..
            while (line != null) {
                line = reader.readLine();
                if (!StringUtils.isEmpty(line)) {
                    sc = new Scanner(line);
                    while (sc.hasNext()) {
                        // remove all non-alphabetic chars and convert to lower case
                        String word = sc.next().replaceAll("[^A-Za-z]", "").toLowerCase();
                        if (dict.containsKey(word)) {
                            // update the existing entry if present
                            dict.get(word).add(reader.getLineNumber());
                        } else {
                            // or add a new word if not present yet
                            dict.put(word, Lists.newArrayList(reader.getLineNumber()));
                        }
                    }
                }
            }
            Long end = System.currentTimeMillis();
            System.out.println("Procesed in: " + (end - start) + "ms ( approx. " + (end - start) / 1000 + "s)");
        } catch (Exception e) {
            System.out.println(String.format("File [%s] not found", FILE_NAME));
            System.exit(0);
        }
    }
    
    public List<String> getLines(List<Integer> lineNumbers) throws Exception {
        List<String> lines = new ArrayList<String>();
        BufferedReader buffReader = new BufferedReader(new FileReader(FILE_NAME));
        LineNumberReader reader = new LineNumberReader(buffReader);
        int readed = 1;
        for (Integer lineNum : lineNumbers) {
            while (readed < lineNum) {
                reader.readLine();
                readed++;
            }
            String line = reader.readLine();
            readed++;
            if (line != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public Dictionary<String, List<Integer>> getDict() {
        return dict;
    }
    
}
