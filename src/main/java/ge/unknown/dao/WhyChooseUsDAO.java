package ge.unknown.dao;

import ge.unknown.entities.WhyChooseUs;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 4/1/2017.
 */
@Repository
public class WhyChooseUsDAO extends PaginationAndFullSearchQuery<WhyChooseUs> {

    public WhyChooseUsDAO(){
        super(WhyChooseUs.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
