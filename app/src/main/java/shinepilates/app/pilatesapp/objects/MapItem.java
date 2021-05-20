package shinepilates.app.pilatesapp.objects;

public class MapItem {
    private String studioName;
    private String studioDescription;
    private int studioImage;

    public MapItem(String studioName, String studioDescription, int studioImage){
        this.studioName = studioName;
        this.studioDescription = studioDescription;
        this.studioImage = studioImage;
    }



    public String getStudioName() {
        return studioName;
    }

    public String getStudioDescription() {
        return studioDescription;
    }

    public int getStudioImage() {
        return studioImage;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public void setStudioDescription(String studioDescription) {
        this.studioDescription = studioDescription;
    }

    public void setStudioImage(int studioImage) {
        this.studioImage = studioImage;
    }
}
