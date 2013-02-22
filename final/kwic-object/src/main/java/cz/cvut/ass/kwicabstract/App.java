package cz.cvut.ass.kwicabstract;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        Input i = new Input("input.txt");
        i.readAndParseInputFile();
        Shifter s = new Shifter(i);
        s.circularShiftAndAlphabetization();
        Output o = new Output(s);
        o.printOutput();
    }

}
