package ge.unknown.dao;

import ge.unknown.entities.OurTeam;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 3/31/2017.
 */
@Repository
public class OurTeamDAO extends PaginationAndFullSearchQuery<OurTeam> {

    public OurTeamDAO() {
        super(OurTeam.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
