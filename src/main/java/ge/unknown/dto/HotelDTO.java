package ge.unknown.dto;

import ge.unknown.entities.HotelAttributes;
import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJaniko on 3/10/2017.
 */
public class HotelDTO extends SuperDTO {

    private Long id;
    private CityDTO city;
    private TitleDescriptionTranslation description;
    private SEOLinks links;
    private List<String> gallery = new ArrayList<>();
    private Integer starCount = 0;
    private Integer roomCount = 0;
    private Integer adultAmount = 0;
    private Integer childrenAmount = 0;
    private HotelAttributes att;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public TitleDescriptionTranslation getDescription() {
        return description;
    }

    public void setDescription(TitleDescriptionTranslation description) {
        this.description = description;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
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
