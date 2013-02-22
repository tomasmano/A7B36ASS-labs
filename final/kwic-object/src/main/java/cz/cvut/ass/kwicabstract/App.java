package cz.cvut.ass.kwicabstract;

/**
 * 
 * @author j
 */
public class App {
    /**
     * main class
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        Input i = new Input("tolstoj.txt");
        Shifter s = new Shifter();
        Output o = new Output();
        i.readAndParseInputFile();
        s.circularShiftAndAlphabetization(i);
        o.printOutput(s);
    }

}
