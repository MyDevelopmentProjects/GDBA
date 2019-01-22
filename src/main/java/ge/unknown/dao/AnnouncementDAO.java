package ge.unknown.dao;

import ge.unknown.entities.Announcement;
import ge.unknown.entities.User;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikheil on 7/7/2017.
 */
@Repository
public class AnnouncementDAO extends PaginationAndFullSearchQuery<Announcement> {


    public AnnouncementDAO(){
        super(Announcement.class);
    }


    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }

}
