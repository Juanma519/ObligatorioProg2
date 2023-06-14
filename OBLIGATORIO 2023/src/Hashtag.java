
import java.time.LocalDateTime;

public class Hashtag {
    private long id;
    private String text;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Hashtag(long id,String text) {
        this.id = id;
        this.text = text;


    }
}
