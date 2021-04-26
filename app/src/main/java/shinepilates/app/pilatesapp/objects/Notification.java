package shinepilates.app.pilatesapp.objects;

public class Notification {
    private String mainText;
    private String date;
    public Notification(String date, String mainText){
        this.mainText = mainText;
        this.date = date;
    }

    public String getText() {
        return mainText;
    }

    public void setText(String text) {
        this.mainText = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
