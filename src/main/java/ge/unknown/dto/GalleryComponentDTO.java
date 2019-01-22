package ge.unknown.dto;

import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJaniko on 7/12/2017.
 */
public class GalleryComponentDTO extends SuperDTO {

    private Long id;
    private List<String> gallery = new ArrayList<>();
    private TitleDescriptionTranslation translation;
    private SEOLinks seoLinks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public TitleDescriptionTranslation getTranslation() {
        return translation;
    }

    public void setTranslation(TitleDescriptionTranslation translation) {
        this.translation = translation;
    }

    public SEOLinks getSeoLinks() {
        return seoLinks;
    }

    public void setSeoLinks(SEOLinks seoLinks) {
        this.seoLinks = seoLinks;
    }
}
