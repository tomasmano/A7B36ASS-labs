package app;

import com.mycompany.kwicpipesnfilters.Alphabetizer;
import com.mycompany.kwicpipesnfilters.CircularShifter;
import com.mycompany.kwicpipesnfilters.Input;
import com.mycompany.kwicpipesnfilters.Output;
import com.mycompany.kwicpipesnfilters.Pipe;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {
        try {
            Pipe p1 = new Pipe();
            Pipe p2 = new Pipe();
            Pipe p3 = new Pipe();
            
            Input i = new Input(new FileInputStream(new File("tolstoj.txt")), p1);
            CircularShifter cs = new CircularShifter(p1, p2);
            Alphabetizer a = new Alphabetizer(p2, p3);
            Output o = new Output(p3, null);
            
            i.start();
            cs.start();
            a.start();
            o.start();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
