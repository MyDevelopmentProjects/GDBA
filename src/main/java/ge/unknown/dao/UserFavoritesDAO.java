package ge.unknown.dao;

import ge.unknown.entities.UserFavorites;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikheil on 7/7/2017.
 */
@Repository
public class UserFavoritesDAO extends PaginationAndFullSearchQuery<UserFavorites> {

    public UserFavoritesDAO(){
        super(UserFavorites.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
