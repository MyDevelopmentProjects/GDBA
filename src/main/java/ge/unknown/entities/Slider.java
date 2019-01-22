package ge.unknown.entities;

import ge.unknown.entities.translation.SliderTranslation;
import ge.unknown.enums.EFaqCategory;
import ge.unknown.enums.ESliderSection;

import javax.persistence.*;

/**
 * Created by MJaniko on 3/7/2017.
 */
@Entity
@Table(name = "slider")
public class Slider extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="image")
    private String image;

    @Column(name = "href")
    private String href;

    @Embedded
    private SliderTranslation captions;

    @Column(name = "bg_color", columnDefinition = "VARCHAR(50) COLLATE utf8mb4_unicode_ci")
    private String bgColor;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "is_video", nullable = false)
    private Boolean video = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "section")
    private ESliderSection section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public SliderTranslation getCaptions() {
        return captions;
    }

    public void setCaptions(SliderTranslation captions) {
        this.captions = captions;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public ESliderSection getSection() {
        return section;
    }

    public void setSection(ESliderSection section) {
        this.section = section;
    }
}
