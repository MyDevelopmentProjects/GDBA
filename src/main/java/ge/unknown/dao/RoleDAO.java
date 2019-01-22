package ge.unknown.dao;

import ge.unknown.entities.Role;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Repository
public class RoleDAO extends PaginationAndFullSearchQuery<Role>{

    public RoleDAO() {
        super(Role.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
