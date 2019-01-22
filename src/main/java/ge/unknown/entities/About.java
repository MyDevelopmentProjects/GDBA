package ge.unknown.entities;

import ge.unknown.entities.translation.TitleDescriptionTranslation;

import javax.persistence.*;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Entity
@Table(name = "about")
public class About extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "image_url")
    private String imageURL;

    @Embedded
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
