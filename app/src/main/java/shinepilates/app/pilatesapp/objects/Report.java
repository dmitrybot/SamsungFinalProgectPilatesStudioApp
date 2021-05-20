package shinepilates.app.pilatesapp.objects;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Report {
    private Long id;

    private String maintext;
    private String date;
    private String name;

    /*public Report(String maintext, String date, String name){
        this.maintext = maintext;
        this.date = date;
        this.name = name;
    }*/

    public Report(Long id, String maintext, String date, String name){
        this.id = id;
        this.maintext = maintext;
        this.date = date;
        this.name = name;
    }
}
