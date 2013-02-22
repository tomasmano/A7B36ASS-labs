/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicobject;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author j
 */
public class Shifter {
    private List<String> contexts = new ArrayList<String>();

    public Shifter() {
    }

    public List<String> getContext(String word, Input input) throws Exception {
        if (!input.getDict().containsKey(word)) {
            return null;
        }
        List<String> lines = input.getLines(input.getDict().get(word));
        StringTokenizer tokenizer;
        for (String line : lines) {
            tokenizer = new StringTokenizer(line);
            List<String> parsed;
            parsed = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()){
                parsed.add(tokenizer.nextToken() + " ");
            }    
            StringBuilder sb;
            for (int i = 0; i < parsed.size(); i++) {
                String first = parsed.get(0);
                sb = new StringBuilder();
                for (int j = 0; j < parsed.size() - 1; j++) {
                    parsed.set(j, parsed.get(j+1));
                    sb.append(parsed.get(j));
                }
                parsed.set(parsed.size()-1, first);
                sb.append(first);
                contexts.add(sb.toString());
            }
        }
        return contexts;
    }

    public List<String> getContexts() {
        return contexts;
    }
    
    
}
