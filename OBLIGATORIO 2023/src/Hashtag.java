
import java.time.LocalDateTime;

public class Hashtag {
    private long id;
    private String text;
    private int usosDia;

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
    public void aumentarUsos(){
        this.usosDia++;
    }
    public void resetearUsos(){
        this.usosDia=0;
    }
    public int getUsosDia(){
        return this.usosDia;
    }
}
