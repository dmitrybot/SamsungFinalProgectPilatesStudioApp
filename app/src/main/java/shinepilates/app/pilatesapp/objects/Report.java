package shinepilates.app.pilatesapp.objects;

public class Report {
    private String mainText;
    private String date;
    private String name;
    public Report(String name, String date, String mainText){
        this.mainText = mainText;
        this.date = date;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
