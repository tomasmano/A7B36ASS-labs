package com.mycompany.kwicobject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>();
    private static int CONTEXT_SIZE = 5;
    private static String FILE_NAME = "";

    public static void main(String[] args) throws Exception {
//        FILE_NAME = readInputKeyword("Enter file..");
//        Dictionary<String, List<Integer>> dictionary;
//        dictionary = new Dictionary<String, List<Integer>>();
//        Input i = new Input(FILE_NAME, dictionary);
//        i.readText();
//        Shifter shifter = new Shifter();
//        String word = readInputKeyword("Searched word...");
//        shifter.getContext(word, i);
//        
//        Alphabetizer a = new Alphabetizer(shifter);
//        a.getAlphabetisizedContext();
//        
//        Output o = new Output(a);
//        o.printOutput(word, dictionary, shifter);
//        
//        for (String s : perm) {
//            System.out.println(s);
//        }
//        do {
//            
//        } while (!readInputKeyword("exit / anything").equals("exit"));
        
        Kwic k = new Kwic("input.txt");
        k.readAndParseInputFile();
        k.circularShiftAndAlphabetization();
        k.outputAndPrint();
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
}
