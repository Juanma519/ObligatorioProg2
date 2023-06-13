
import java.time.LocalDateTime;

public class Hashtag {
    private long id;
    private String text;
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Hashtag(long id,String text, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.date=date;

    }
    public Hashtag(String text, LocalDateTime date) {
        this.text = text;
        this.date=date;

    }
}
