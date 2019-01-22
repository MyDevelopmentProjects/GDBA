package ge.unknown.dto;

import ge.unknown.entities.translation.TitleTranslation;

/**
 * Created by MJaniko on 7/12/2017.
 */
public class GalleryCategoryDTO extends SuperDTO {

    private Long id;
    private TitleTranslation translation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TitleTranslation getTranslation() {
        return translation;
    }

    public void setTranslation(TitleTranslation translation) {
        this.translation = translation;
    }
}
