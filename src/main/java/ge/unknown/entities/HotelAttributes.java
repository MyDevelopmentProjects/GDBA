package ge.unknown.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by MJaniko on 5/1/2017.
 */
@Embeddable
public class HotelAttributes {

    @Column(name = "has_enthernet", columnDefinition = "bit(1) DEFAULT 0")
    private boolean ethernet = false;

    @Column(name = "has_restourant", columnDefinition = "bit(1) DEFAULT 0")
    private boolean restourant = false;

    @Column(name = "has_kitchen", columnDefinition = "bit(1) DEFAULT 0")
    private boolean kitchen = false;

    @Column(name = "has_enthertaiment", columnDefinition = "bit(1) DEFAULT 0")
    private boolean enthertaiment = false;

    @Column(name = "has_parking", columnDefinition = "bit(1) DEFAULT 0")
    private boolean parking = false;

    @Column(name = "is_pet_allowed", columnDefinition = "bit(1) DEFAULT 0")
    private boolean petAllowed = false;

    @Column(name = "has_conference_room", columnDefinition = "bit(1) DEFAULT 0")
    private boolean conferenceRoom = false;

    @Column(name = "has_bar", columnDefinition = "bit(1) DEFAULT 0")
    private boolean bar = false;

    @Column(name = "has_spa_services", columnDefinition = "bit(1) DEFAULT 0")
    private boolean spaServices = false;

    @Column(name = "has_hot_tube", columnDefinition = "bit(1) DEFAULT 0")
    private boolean hotTub = false;

    @Column(name = "has_gym", columnDefinition = "bit(1) DEFAULT 0")
    private boolean gym = false;

    @Column(name = "has_handicap", columnDefinition = "bit(1) DEFAULT 0")
    private boolean handicap = false;

    @Column(name = "has_play_place", columnDefinition = "bit(1) DEFAULT 0")
    private boolean playPlace = false;

    @Column(name = "has_door_man", columnDefinition = "bit(1) DEFAULT 0")
    private boolean doorMan = false;

    @Column(name = "has_bike_rental", columnDefinition = "bit(1) DEFAULT 0")
    private boolean bikeRental = false;

    @Column(name = "has_swimming_pool", columnDefinition = "bit(1) DEFAULT 0")
    private boolean swimmingPool = false;

    @Column(name = "has_television", columnDefinition = "bit(1) DEFAULT 0")
    private boolean television = false;

    @Column(name = "is_secured", columnDefinition = "bit(1) DEFAULT 0")
    private boolean secure = false;

    @Column(name = "latitude", columnDefinition = "DECIMAL(9,6) DEFAULT 0")
    private double latitude;

    @Column(name = "longitude", columnDefinition = "DECIMAL(9,6) DEFAULT 0")
    private double longitude;

    public boolean isEthernet() {
        return ethernet;
    }

    public void setEthernet(boolean ethernet) {
        this.ethernet = ethernet;
    }

    public boolean isRestourant() {
        return restourant;
    }

    public void setRestourant(boolean restourant) {
        this.restourant = restourant;
    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }

    public boolean isEnthertaiment() {
        return enthertaiment;
    }

    public void setEnthertaiment(boolean enthertaiment) {
        this.enthertaiment = enthertaiment;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isPetAllowed() {
        return petAllowed;
    }

    public void setPetAllowed(boolean petAllowed) {
        this.petAllowed = petAllowed;
    }

    public boolean isConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(boolean conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isSpaServices() {
        return spaServices;
    }

    public void setSpaServices(boolean spaServices) {
        this.spaServices = spaServices;
    }

    public boolean isHotTub() {
        return hotTub;
    }

    public void setHotTub(boolean hotTub) {
        this.hotTub = hotTub;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public boolean isHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public boolean isPlayPlace() {
        return playPlace;
    }

    public void setPlayPlace(boolean playPlace) {
        this.playPlace = playPlace;
    }

    public boolean isDoorMan() {
        return doorMan;
    }

    public void setDoorMan(boolean doorMan) {
        this.doorMan = doorMan;
    }

    public boolean isBikeRental() {
        return bikeRental;
    }

    public void setBikeRental(boolean bikeRental) {
        this.bikeRental = bikeRental;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
