package shinepilates.app.pilatesapp.objects;

public class NewsItem {
    private int ImageNews;
    private String date;
    private String tag;
    private String main_text;

    public NewsItem(int imageNews, String date, String tag, String main_text){
        ImageNews = imageNews;
        this.date = date;
        this.tag = tag;
        this.main_text = main_text;
    }

    public int getImageNews() {
        return ImageNews;
    }

    public void setImageNews(int imageNews) {
        ImageNews = imageNews;
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
        return main_text;
    }

    public void setMain_text(String main_text) {
        this.main_text = main_text;
    }
}
