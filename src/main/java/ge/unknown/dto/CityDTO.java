package ge.unknown.dto;

import ge.unknown.entities.translation.TitleTranslation;

/**
 * Created by MJaniko on 3/8/2017.
 */
public class CityDTO {

    private Long id;
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
