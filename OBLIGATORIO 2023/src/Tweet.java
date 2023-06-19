import uy.edu.um.adt.Hash.HashImpl;
import uy.edu.um.adt.Hash.MyHash;
import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
import uy.edu.um.adt.LinkedList.MyList;

import java.time.LocalDateTime;

public class Tweet {
    private long id;
    private String content;
    private String user;
    private LocalDateTime date;
    private String source;
    private int likes;
    private boolean isRetweet;
    private MyLinkedListImpl<Hashtag> hashtags;//OJO EL ORDEN DE CREACION DE TWEETS
    private int cantidadHashtags;
    public Tweet(long id, String content, String user, LocalDateTime date, String source, int likes, boolean isRetweet) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.date = date;
        this.source = source;
        this.likes = likes;
        this.isRetweet = isRetweet;
        this.hashtags = new MyLinkedListImpl();
        this.cantidadHashtags=0;
    }
    public void addHashtag(Hashtag hashtag){
        hashtags.add(hashtag);
        this.cantidadHashtags+=1;
    }

    public int getCantidadHashtags() {
        return cantidadHashtags;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public MyLinkedListImpl getHashtags() {
        return hashtags;
    }

}
