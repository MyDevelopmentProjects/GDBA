package ge.unknown.dto;

import ge.unknown.entities.translation.TitleDescriptionTranslation;

/**
 * Created by MJaniko on 4/1/2017.
 */
public class WhyChooseUsDTO {

    private Long id;
    private String icon;
    private TitleDescriptionTranslation translation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public TitleDescriptionTranslation getTranslation() {
        return translation;
    }

    public void setTranslation(TitleDescriptionTranslation translation) {
        this.translation = translation;
    }
}
