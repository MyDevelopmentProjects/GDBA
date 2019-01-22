package ge.unknown.dao;

import ge.unknown.entities.Permission;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Repository
public class PermissionDAO extends PaginationAndFullSearchQuery<Permission>{

    public PermissionDAO() {
        super(Permission.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
