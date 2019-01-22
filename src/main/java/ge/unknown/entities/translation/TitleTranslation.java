package ge.unknown.entities.translation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by MJaniko on 3/6/2017.
 */
@Embeddable
public class TitleTranslation extends Translation {

    @Column(name = "title_en")
    private String titleEN;

    @Column(name = "title_ru")
    private String titleRU;

    public String getTitleEN() {
        return titleEN;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public String getTitleRU() {
        return titleRU;
    }

    public void setTitleRU(String titleRU) {
        this.titleRU = titleRU;
    }
}
