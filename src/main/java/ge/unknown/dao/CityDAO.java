package ge.unknown.dao;

import ge.unknown.entities.City;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Repository
public class CityDAO extends PaginationAndFullSearchQuery<City> {

    public CityDAO() {
        super(City.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
