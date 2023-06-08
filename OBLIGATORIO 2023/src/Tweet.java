import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
import uy.edu.um.adt.LinkedList.MyList;

public class Tweet {
    private long id;
    private String content;
    private User user;
    private String date;
    private String source;
    private double likes;
    private boolean isRetweet;
    private MyList<Hashtag> hashtags; //OJO EL ORDEN DE CREACION DE TWEETS
    public Tweet(long id, String content, User user, String date, String source, double likes, boolean isRetweet) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.date = date;
        this.source = source;
        this.likes = likes;
        this.isRetweet = isRetweet;
        this.hashtags = new MyLinkedListImpl<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public MyList<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(MyList<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
