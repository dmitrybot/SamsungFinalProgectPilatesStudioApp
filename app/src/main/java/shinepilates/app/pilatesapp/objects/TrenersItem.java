package shinepilates.app.pilatesapp.objects;

public class TrenersItem {
    private Long id;
    private String trenersname;
    private String trenerspos;
    private String trenersdescr;

    public TrenersItem(Long id, String TrenersName, String TrenersPos, String TrenersDescr){
        this.id = id;
        trenersname = TrenersName;
        trenerspos = TrenersPos;
        trenersdescr = TrenersDescr;
    }

    public String getTrenersName(){
        return trenersname;
    }

    public String getTrenersPos(){
        return trenerspos;
    }

    public String getTrenersDescr(){
        return trenersdescr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
