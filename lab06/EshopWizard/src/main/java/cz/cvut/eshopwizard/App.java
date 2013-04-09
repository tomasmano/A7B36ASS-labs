package cz.cvut.eshopwizard;

import cz.cvut.eshopwizard.tree.Bus;
import cz.cvut.eshopwizard.tree.BusClassic;
import cz.cvut.eshopwizard.tree.BusModern;
import cz.cvut.eshopwizard.tree.PcCart;
import cz.cvut.eshopwizard.tree.Case;
import cz.cvut.eshopwizard.tree.ClassicProcessor;
import cz.cvut.eshopwizard.tree.ModernProcessor;
import cz.cvut.eshopwizard.tree.Processor;
import cz.cvut.eshopwizard.tree.SoundCard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        //////////  user input  //////////

        System.out.println("Select equipment:");
        System.out.println("[1] classic bus (supports classic intel processors)");
        System.out.println("[2] modern bus (supports modern intel processors)");
        System.out.println("[3] case");
        System.out.println("[4] modern intel (modern bus required)");
        System.out.println("[5] classic intel (classic bus required)");
        System.out.println("[6] sound card");
        PcCart cart = new PcCart("my pc", 0, 0);
        int input = readInputKeyword("Select equipment's number. If you want to go to checkout, insert '-1'");
        while (input != -1) {

            switch (input) {
                case 1:
                    BusClassic bc = new BusClassic("classic bus", 100, 120);
                    cart.add(bc);
                    break;
                case 2:
                    BusModern bm = new BusModern("modern bus", 300, 80);
                    cart.add(bm);
                    break;
                case 3:
                    Case c = new Case("my case", 50, 20);
                    cart.add(c);
                    break;
                case 4:
                    ModernProcessor mp = new ModernProcessor("modern intel", 500, 150);
                    cart.getBus().add(mp);
                    break;
                case 5:
                    ClassicProcessor cp = new ClassicProcessor("classic intel", 200, 200);
                    cart.getBus().add(cp);
                    break;
                case 6:
                    SoundCard sc = new SoundCard("my soundcard", 90, 40);
                    cart.add(sc);
                    break;
                default:
                    System.out.println("Input not recoginezd");
                    break;
            }
            input = readInputKeyword(String.format("Select next equipment's number. Actual amount in you cart is [%s]. If you want to go to checkout, insert '-1'", cart.getPrice()));
        }
        System.out.format("Final price is [%s] and ", cart.getPrice());
        System.out.format("Energy import is [%s].%n", cart.getEnergyImport());
        System.out.println("Thank you for your purchase.");

    }

    public static int readInputKeyword(String heading) {
        System.out.println(heading);
        String input = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            input = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(input);
    }
}
