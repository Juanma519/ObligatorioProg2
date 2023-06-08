import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
import uy.edu.um.adt.LinkedList.MyList;

public class User {
    private long id;
    private String name;
    private MyList<Tweet> tweets;

    //AGREGARLE UNA LISTA CON TWEETS, PERO NO SABEMOS DE Q TIPO

    public User(long id, String name) {
        this.id = id;
        this.name = name;
        this.tweets = new MyLinkedListImpl<>();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(MyList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
