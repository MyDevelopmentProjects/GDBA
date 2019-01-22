package ge.unknown.entities;

import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Entity
@Table(name = "tour")
public class Tour extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    @Embedded
    private TitleDescriptionTranslation translation;

    @Embedded
    private SEOLinks links;

    @ElementCollection
    @CollectionTable(name = "tour_gallery", joinColumns = @JoinColumn(name = "tour_id"))
    @Column(name = "path")
    private List<String> gallery = new ArrayList<>();

    @Column(name = "stars", columnDefinition = "INT DEFAULT 0")
    private int stars = 0;

    @Column(name = "tour_price", columnDefinition = "INT DEFAULT 0")
    private int price = 0;

    @Column(name = "adult", columnDefinition = "INT DEFAULT 0")
    private int adult = 0;

    @Column(name = "child", columnDefinition = "INT DEFAULT 0")
    private int child = 0;

    @Column(name = "period", columnDefinition = "INT DEFAULT 0")
    private int period = 0;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public TitleDescriptionTranslation getTranslation() {
        return translation;
    }

    public void setTranslation(TitleDescriptionTranslation translation) {
        this.translation = translation;
    }

    public SEOLinks getLinks() {
        return links;
    }

    public void setLinks(SEOLinks links) {
        this.links = links;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
