package ge.unknown.dto;

import ge.unknown.entities.translation.SliderTranslation;
import ge.unknown.enums.ESliderSection;

/**
 * Created by MJaniko on 3/7/2017.
 */
public class SliderDTO extends SuperDTO {

    private Long id;
    private String image;
    private String href;
    private SliderTranslation captions;
    private String bgColor;
    private Boolean active = true;
    private Boolean video = true;
    private ESliderSection section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public SliderTranslation getCaptions() {
        return captions;
    }

    public void setCaptions(SliderTranslation captions) {
        this.captions = captions;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public ESliderSection getSection() {
        return section;
    }

    public void setSection(ESliderSection section) {
        this.section = section;
    }
}
