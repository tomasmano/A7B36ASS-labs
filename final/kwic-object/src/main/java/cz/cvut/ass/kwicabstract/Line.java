/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.ass.kwicabstract;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author j
 */
public class Line {
    private int number;
    private String[] words;

    public Line(int number, String line) {
        this.number = number;
        words = parseLine(line);
    }

    /**
     * parse line into separate words and replace non-alphabetic characters
     * @param line
     * @return 
     */
    private String[] parseLine(String line) {
        StringTokenizer sb = new StringTokenizer(line);
        List<String> w = new ArrayList<String>();
        int count = 0;
        while(sb.hasMoreTokens()){
            String tok = sb.nextToken();
            w.add(tok.replaceAll("[^A-Za-z]", ""));
            ++count;
        }
        return w.toArray(new String[count]);
    }
    
    public int getSize(){
        return words.length;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
