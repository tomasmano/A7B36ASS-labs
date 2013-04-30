package cz.cvut.ass.twitterobserver;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Tweet {

    private User user;
    private String msg;

    public Tweet(User user, String msg) {
        this.user = user;
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format("[%s] said: %s", user.getName(), msg);
    }
}
