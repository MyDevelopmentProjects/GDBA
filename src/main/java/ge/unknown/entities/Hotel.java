package ge.unknown.entities;

import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Entity
@Table(name = "hotel")
public class Hotel extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Embedded
    private TitleDescriptionTranslation description;

    @Embedded
    private SEOLinks links;

    @ElementCollection
    @CollectionTable(name = "hotel_gallery", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "path")
    private List<String> gallery = new ArrayList<>();

    @Column(name = "star_count", columnDefinition = "INT DEFAULT 0")
    private Integer starCount = 0;

    @Column(name = "room_count", columnDefinition = "INT DEFAULT 0")
    private Integer roomCount = 0;

    @Column(name = "adult_amount", columnDefinition = "INT DEFAULT 0")
    private Integer adultAmount = 0;

    @Column(name = "chldren_amount", columnDefinition = "INT DEFAULT 0")
    private Integer childrenAmount = 0;

    @Embedded
    private HotelAttributes att;

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

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public TitleDescriptionTranslation getDescription() {
        return description;
    }

    public void setDescription(TitleDescriptionTranslation description) {
        this.description = description;
    }

    public SEOLinks getLinks() {
        return links;
    }

    public void setLinks(SEOLinks links) {
        this.links = links;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getAdultAmount() {
        return adultAmount;
    }

    public void setAdultAmount(Integer adultAmount) {
        this.adultAmount = adultAmount;
    }

    public Integer getChildrenAmount() {
        return childrenAmount;
    }

    public void setChildrenAmount(Integer childrenAmount) {
        this.childrenAmount = childrenAmount;
    }

    public HotelAttributes getAtt() {
        return att;
    }

    public void setAtt(HotelAttributes att) {
        this.att = att;
    }
}
