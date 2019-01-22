package ge.unknown.entities;

import ge.unknown.entities.translation.TitleDescriptionTranslation;

import javax.persistence.*;

/**
 * Created by MJaniko on 4/1/2017.
 */
@Entity
@Table(name = "our_travel_agency")
public class OurTravelAgency extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "icon")
    private String icon;

    @Embedded
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
