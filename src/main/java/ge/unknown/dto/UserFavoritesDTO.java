package ge.unknown.dto;

/**
 * Created by Mikheil on 7/7/2017.
 */
public class UserFavoritesDTO extends SuperDTO{

    private Long id;
    private UserDTO user;
    private TourDTO tour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TourDTO getTour() {
        return tour;
    }

    public void setTour(TourDTO tour) {
        this.tour = tour;
    }
}
