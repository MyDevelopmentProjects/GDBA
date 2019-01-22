package ge.unknown.dto;

import ge.unknown.entities.translation.PositionTranlation;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

/**
 * Created by MJaniko on 3/31/2017.
 */
public class OurTeamDTO  {

    private Long id;
    private String imageURL;
    private TitleDescriptionTranslation person;
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
