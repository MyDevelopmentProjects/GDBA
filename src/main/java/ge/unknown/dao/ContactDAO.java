package ge.unknown.dao;

import ge.unknown.entities.Contact;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MJaniko on 3/12/2017.
 */
@Repository
public class ContactDAO extends PaginationAndFullSearchQuery<Contact>{

    public ContactDAO() {
        super(Contact.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
