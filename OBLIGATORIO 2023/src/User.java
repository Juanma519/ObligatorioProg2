import uy.edu.um.adt.Hash.HashImpl;
import uy.edu.um.adt.Hash.MyHash;

public class User {
    private long id;
    private String name;
    private int favoritos;
    private MyHash<Long,Tweet> tweets; // Se puede cambiar el tipo de lista segun convenga
    //Parece que conviene Hash,porque tiene el tiempo de ver el size mas corto.
    // no se como es eso del LONG ,POSIBLE ERROR


    public User(long id, String name) {
        this.id = id;
        this.name = name;
        this.tweets = new HashImpl<>(500); //el size habria que ver cuantos tweets por usuario hay
        this.favoritos=0;

    }

    public int getFavoritos() {
        return favoritos;
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

    public MyHash<Long,Tweet> getTweets() {
        return tweets;
    }

    public void addTweet(Long idTweet, Tweet tweet) {
        this.tweets.put(idTweet,tweet);
        this.favoritos+=tweet.getLikes();
    }

}
