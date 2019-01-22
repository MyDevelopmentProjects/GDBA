package ge.unknown.entities;

import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJaniko on 7/12/2017.
 */
@Entity
@Table(name = "gallery_component")
public class GalleryComponent extends  SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "gallery_images", joinColumns = @JoinColumn(name = "gallery_id"))
    @Column(name = "path")
    private List<String> gallery = new ArrayList<>();

    @Embedded
    private TitleDescriptionTranslation translation;

    @Embedded
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
