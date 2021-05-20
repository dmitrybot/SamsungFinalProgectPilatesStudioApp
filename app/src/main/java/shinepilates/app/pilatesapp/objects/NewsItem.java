package shinepilates.app.pilatesapp.objects;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewsItem {
    private Long id;
    private String date;
    private String tag;
    private String maintext;

    public NewsItem(Long id, String date, String tag, String main_text){
        this.id = id;
        this.date = date;
        this.tag = tag;
        this.maintext = main_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMain_text() {
        return maintext;
    }

    public void setMainText(String main_text) {
        this.maintext = main_text;
    }
}
