<<<<<<< HEAD
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.ass.kwicshared;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
=======
package cz.cvut.ass.kwicshared;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
>>>>>>> neworigin/slave
import org.apache.commons.lang3.StringUtils;

/**
 *
<<<<<<< HEAD
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
=======
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Kwic {

    private static Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>();
    private static int CONTEXT_SIZE = 5;
    private static String FILE_NAME = "";

    public static void main(String[] args) throws Exception {
        FILE_NAME = readInputKeyword("Enter file..");
        readText(FILE_NAME); //input.txt
        CONTEXT_SIZE = new Integer(readInputKeyword("Set context size (how many words should appear in one line when the given word is found).."));
        while (true) {
            printOutput(readInputKeyword("Enter word.."));
        }
    }

    public static String readInputKeyword(String heading) {
        System.out.println(heading);
        String input = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            input = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void printOutput(String inputKeyWord) throws Exception {
        String input = inputKeyWord.toLowerCase();
        List<Integer> numLines = dict.get(inputKeyWord);
        if (numLines == null) {
            System.out.println(String.format("Word [%s] not found..", inputKeyWord));
            return;
        }
        System.out.println("Occurence on lines [Number of times: " + numLines.size() + "x]: " + numLines);
        System.out.println("Word '" + inputKeyWord + "' is appearing in these contexts: ");
        Long start = System.currentTimeMillis();
        // do magic.. 
        List<String> res = getContext(inputKeyWord);
        Long end = System.currentTimeMillis();
        System.out.println("Procesed in: " + (end - start) + "ms");
        for (String out : res) {
            System.out.println(out);
        }
    }

    public static void readText(String input) throws Exception {
        try {
            // setup..
            BufferedReader buffReader = new BufferedReader(new FileReader(input));
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
>>>>>>> neworigin/slave
                }
            }
            Long end = System.currentTimeMillis();
            System.out.println("Procesed in: " + (end - start) + "ms ( approx. " + (end - start) / 1000 + "s)");
<<<<<<< HEAD
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
=======
        } catch (Exception e) {
            System.out.println(String.format("File [%s] not found", input));
            System.exit(0);
        }
    }

    private static List<String> getContext(String word) throws Exception {
        List<String> contexts = new ArrayList<String>();
        if (!dict.containsKey(word)) {
            return null;
        }
        List<String> lines = getLines(dict.get(word));

        for (String line : lines) {
            String[] words = line.split(" ");

            String fullContext = "";
            for (int i = 0; i < words.length; i++) {

                if (words[i].replaceAll("[^A-Za-z]", "").toLowerCase().equals(word)) {
//            
                    String prefix = getPrevWords(words, i);

                    String postfix = getNextWords(words, i);

                    fullContext = " ..." + prefix + ">>[" + words[i] + "]<< " + postfix + "... ";
                    contexts.add(fullContext);

                    fullContext = "";
                }

            }
        }
        return contexts;
    }

    private static String getPrevWords(String[] words, int currIndex) {
        String prefix = "";
        int k = currIndex;
        int counter = 0;
        while (k > 0 && counter < CONTEXT_SIZE) {
            prefix = words[k - 1] + " " + prefix;
            k--;
            counter++;
        }
        return prefix;
    }

    private static String getNextWords(String[] words, int currIndex) {
        String postfix = "";
        int counter = 0;
        int j = currIndex;
        while (j < words.length - 1 && counter < CONTEXT_SIZE) {
            postfix = postfix + words[j + 1] + " ";
            j++;
            counter++;
        }
        return postfix;
    }

    private static List<String> getLines(List<Integer> lineNumbers) throws Exception {
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
>>>>>>> neworigin/slave
    }
}
