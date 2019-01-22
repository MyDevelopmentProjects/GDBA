package ge.unknown.entities;

import ge.unknown.entities.translation.PositionTranlation;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import javax.persistence.*;

/**
 * Created by MJaniko on 3/31/2017.
 */
@Entity
@Table(name = "our_team")
public class OurTeam extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "image_url")
    private String imageURL;

    @Embedded
    private TitleDescriptionTranslation person;

    @Embedded
    private PositionTranlation position;

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

    public TitleDescriptionTranslation getPerson() {
        return person;
    }

    public void setPerson(TitleDescriptionTranslation person) {
        this.person = person;
    }

    public PositionTranlation getPosition() {
        return position;
    }

    public void setPosition(PositionTranlation position) {
        this.position = position;
    }
}
