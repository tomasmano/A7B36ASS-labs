package cz.cvut.ass.twitterobserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        User tomy = new User("tomy");
        User jana = new User("jana");
        User zuza = new User("zuza");
        Twitter twitter = new Twitter();
        twitter.addObserver(tomy);
        twitter.addObserver(jana);
        twitter.addObserver(zuza);
        System.out.println("Welcome to Twitter.");
        System.out.println("Hi Jana, write something ..");
        String input = readInput();
        twitter.tweet(new Tweet(jana, input));
        twitter.tweet(new Tweet(tomy, "Super"));
        twitter.tweet(new Tweet(zuza, "Uff"));
    }

    private static String readInput() {
        String msg = null;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            msg = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
