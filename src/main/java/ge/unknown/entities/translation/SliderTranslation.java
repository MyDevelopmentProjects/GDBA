package ge.unknown.entities.translation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by MJaniko on 3/7/2017.
 */
@Embeddable
public class SliderTranslation {

    @Column(name = "caption_one_en")
    private String captionOneEN;

    @Column(name = "caption_one_ru")
    private String captionOneRU;

    @Column(name = "caption_two_en")
    private String captionTwoEN;

    @Column(name = "caption_two_ru")
    private String captionTwoRU;

    public String getCaptionOneEN() {
        return captionOneEN;
    }

    public void setCaptionOneEN(String captionOneEN) {
        this.captionOneEN = captionOneEN;
    }

    public String getCaptionOneRU() {
        return captionOneRU;
    }

    public void setCaptionOneRU(String captionOneRU) {
        this.captionOneRU = captionOneRU;
    }

    public String getCaptionTwoEN() {
        return captionTwoEN;
    }

    public void setCaptionTwoEN(String captionTwoEN) {
        this.captionTwoEN = captionTwoEN;
    }

    public String getCaptionTwoRU() {
        return captionTwoRU;
    }

    public void setCaptionTwoRU(String captionTwoRU) {
        this.captionTwoRU = captionTwoRU;
    }
}
