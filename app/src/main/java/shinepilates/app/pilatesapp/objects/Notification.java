package shinepilates.app.pilatesapp.objects;

public class Notification {
    private Long id;
    private String maintext;
    private String date;
    private boolean posted;

    public Notification(String date, String mainText){
        this.maintext = mainText;
        this.date = date;
        this.posted = false;
    }

    public Notification(String date, String mainText, Long id, boolean posted){
        this.maintext = mainText;
        this.date = date;
        this.id = id;
        this.posted = posted;
    }

    public String getText() {
        return maintext;
    }

    public void setText(String text) {
        this.maintext = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }
}
