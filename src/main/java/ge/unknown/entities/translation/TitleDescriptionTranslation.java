package ge.unknown.entities.translation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

/**
 * Created by MJaniko on 3/7/2017.
 */
@Embeddable
public class TitleDescriptionTranslation extends Translation{
    @Column(name = "title_en")
    private String titleEN;

    @Column(name = "title_ru")
    private String titleRU;

    @Lob
    @Column(name = "description_en")
    private String descriptionEN;

    @Lob
    @Column(name = "description_ru")
    private String descriptionRU;

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

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public String getDescriptionRU() {
        return descriptionRU;
    }

    public void setDescriptionRU(String descriptionRU) {
        this.descriptionRU = descriptionRU;
    }
}
