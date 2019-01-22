package ge.unknown.entities;

import ge.unknown.entities.translation.TitleDescriptionTranslation;
import ge.unknown.entities.translation.TitleTranslation;

import javax.persistence.*;

/**
 * Created by MJaniko on 7/12/2017.
 */
@Entity
@Table(name = "gallery_category")
public class GalleryCategory extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
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
