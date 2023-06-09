import java.time.LocalDate;

public class Hashtag {
    private long id;
    private String text;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Hashtag(long id,String text, LocalDate date) {
        this.id = id;
        this.text = text;
        this.date=date;

    }
    public Hashtag(String text, LocalDate date) {
        this.text = text;
        this.date=date;

    }
}
