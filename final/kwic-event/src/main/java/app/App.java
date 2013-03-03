package app;

import com.mycompany.kwicevent.Input;
import com.mycompany.kwicevent.Output;
import com.mycompany.kwicevent.Shifter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Input i = new Input("input.txt");
        Shifter s = new Shifter();
        Output o = new Output();
        
        i.addObserver(s);
        s.addObserver(o);
        
        i.readAndParseInputFile();
        o.printOutput();
    }
}
