package ge.unknown.entities.translation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

/**
 * Created by MJaniko on 3/6/2017.
 */
@Embeddable
public class DescriptionTranslation {

    @Lob
    @Column(name = "description_en")
    private String descriptionEN;

    @Lob
    @Column(name = "description_ru")
    private String descriptionRU;

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
