package app;

import com.mycompany.kwicpipesnfilters.Alphabetizer;
import com.mycompany.kwicpipesnfilters.CircularShifter;
import com.mycompany.kwicpipesnfilters.Input;
import com.mycompany.kwicpipesnfilters.Output;
import com.mycompany.kwicpipesnfilters.Pipe;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
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
    }
}
