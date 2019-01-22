package ge.unknown.dto;

import ge.unknown.entities.translation.TitleDescriptionTranslation;
import ge.unknown.enums.EFaqCategory;

/**
 * Created by MJaniko on 4/26/2017.
 */
public class FaqDTO {
    private Long id;
    private EFaqCategory category;
    private TitleDescriptionTranslation translation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EFaqCategory getCategory() {
        return category;
    }

    public void setCategory(EFaqCategory category) {
        this.category = category;
    }

    public TitleDescriptionTranslation getTranslation() {
        return translation;
    }

    public void setTranslation(TitleDescriptionTranslation translation) {
        this.translation = translation;
    }
}
