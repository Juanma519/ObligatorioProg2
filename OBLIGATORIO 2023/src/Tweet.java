public class Tweet {
    private long id;
    private String content;
    private User user;
    private String date;
    private String source;
    private int likes;
    private boolean isRetweet;
    //Agregarle una lista con hashtags, pero no sabemos de q tipo

    public Tweet(long id, String content, User user, String date, String source, int likes, boolean isRetweet) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.date = date;
        this.source = source;
        this.likes = likes;
        this.isRetweet = isRetweet;
    }


}
