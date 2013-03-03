/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package j.hell.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
public class Benchmarker {
    public static final String FILE_NAME = "benchmark.txt";
    
    public static void saveBenchmark(Long time, Class clazz){
            BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(new File(FILE_NAME), true));
            String s = clazz.getSimpleName() + " procesed in: ";            
            bw.write(s);
            bw.write(time.toString() + "ms\n");            
            bw.close();            
        } catch (IOException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
