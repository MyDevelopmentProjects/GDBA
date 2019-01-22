package ge.unknown.dao;

import ge.unknown.entities.Slider;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 3/7/2017.
 */
@Repository
public class SliderDAO extends PaginationAndFullSearchQuery<Slider> {

    public SliderDAO() {
        super(Slider.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }

}
