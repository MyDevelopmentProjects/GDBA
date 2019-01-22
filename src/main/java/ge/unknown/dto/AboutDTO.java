package ge.unknown.dto;

import ge.unknown.entities.translation.TitleDescriptionTranslation;

/**
 * Created by MJaniko on 3/8/2017.
 */
public class AboutDTO {

    private Long id;
    private String imageURL;
    private TitleDescriptionTranslation details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public TitleDescriptionTranslation getDetails() {
        return details;
    }

    public void setDetails(TitleDescriptionTranslation details) {
        this.details = details;
    }
}
