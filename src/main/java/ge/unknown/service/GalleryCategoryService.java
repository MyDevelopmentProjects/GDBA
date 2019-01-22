package ge.unknown.service;

import ge.unknown.dao.GalleryCategoryDAO;
import ge.unknown.dto.GalleryCategoryDTO;
import ge.unknown.entities.GalleryCategory;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mikheil on 7/13/2017.
 */
@Service
public class GalleryCategoryService {

    @Autowired
    private GalleryCategoryDAO galleryCategoryDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<GalleryCategoryDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize, String category) {
        return galleryCategoryDAO.getPaginatedList(GalleryCategory.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize, category).transform(GalleryCategoryDTO.class);
    }

    @Transactional(readOnly = true)
    public GalleryCategory find(Long id) {
        return galleryCategoryDAO.find(id);
    }

    @Transactional(readOnly = true)
    public GalleryCategory first() {
        return galleryCategoryDAO.first();
    }

    @Transactional
    public GalleryCategory save(GalleryCategory galleryCategory) {
        if (galleryCategory.getId() != null) {
            return galleryCategoryDAO.update(galleryCategory);
        }
        return galleryCategoryDAO.create(galleryCategory);
    }

    @Transactional
    public boolean delete(Long id) {
        return galleryCategoryDAO.delete(id);
    }
}
