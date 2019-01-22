package ge.unknown.dao;

import ge.unknown.entities.GalleryCategory;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikheil on 7/13/2017.
 */
@Repository
public class GalleryCategoryDAO extends PaginationAndFullSearchQuery<GalleryCategory> {

    public GalleryCategoryDAO(){
        super(GalleryCategory.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
