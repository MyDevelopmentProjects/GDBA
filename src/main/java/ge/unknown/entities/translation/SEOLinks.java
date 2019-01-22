package ge.unknown.entities.translation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Mikheil on 4/24/2017.
 */
@Embeddable
public class SEOLinks {

    @Column(name = "seo_en")
    private String seoEN;

    @Column(name = "seo_ru")
    private String seoRU;

    public String getSeoEN() {
        return seoEN;
    }

    public void setSeoEN(String seoEN) {
        this.seoEN = seoEN;
    }

    public String getSeoRU() {
        return seoRU;
    }

    public void setSeoRU(String seoRU) {
        this.seoRU = seoRU;
    }
}
