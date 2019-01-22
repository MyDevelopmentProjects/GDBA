package ge.unknown.dto;

import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MJaniko on 3/31/2017.
 */
public class TourDTO extends SuperDTO{

    private Long id;
    private CityDTO city;
    private CategoryDTO category;
    private TitleDescriptionTranslation translation;
    private SEOLinks links;
    private List<String> gallery = new ArrayList<>();
    private int stars = 0;
    private int price = 0;
    private int adult = 0;
    private int child = 0;
    private int period = 0;
    private Date startDate;
    private Date endDate;

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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
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
