package ge.unknown.entities;

import ge.unknown.entities.translation.TitleTranslation;

import javax.persistence.*;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TitleTranslation titles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TitleTranslation getTitles() {
        return titles;
    }

    public void setTitles(TitleTranslation titles) {
        this.titles = titles;
    }
}

