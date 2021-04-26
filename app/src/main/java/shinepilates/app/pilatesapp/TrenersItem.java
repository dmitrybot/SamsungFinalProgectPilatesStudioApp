package shinepilates.app.pilatesapp;

public class TrenersItem {
    private int tImageTreners;
    private String tTrenersName;
    private String tTrenersPos;
    private String tTrenersDescr;

    public TrenersItem(int ImageTreners, String TrenersName, String TrenersPos, String TrenersDescr){
        tImageTreners = ImageTreners;
        tTrenersName = TrenersName;
        tTrenersPos = TrenersPos;
        tTrenersDescr = TrenersDescr;
    }

    public int getImageTreners(){
        return tImageTreners;
    }

    public String getTrenersName(){
        return tTrenersName;
    }

    public String getTrenersPos(){
        return tTrenersPos;
    }

    public String getTrenersDescr(){
        return tTrenersDescr;
    }

}
