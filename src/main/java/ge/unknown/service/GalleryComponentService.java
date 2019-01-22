package ge.unknown.service;

import ge.unknown.dao.GalleryComponentDAO;
import ge.unknown.dto.GalleryComponentDTO;
import ge.unknown.entities.GalleryComponent;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mikheil on 7/13/2017.
 */
@Service
public class GalleryComponentService {

    @Autowired
    private GalleryComponentDAO galleryComponentDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<GalleryComponentDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize, String category) {
        return galleryComponentDAO.getPaginatedList(GalleryComponent.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize, category).transform(GalleryComponentDTO.class);
    }

    @Transactional(readOnly = true)
    public GalleryComponent find(Long id) {
        return galleryComponentDAO.find(id);
    }

    @Transactional(readOnly = true)
    public GalleryComponent first() {
        return galleryComponentDAO.first();
    }

    @Transactional
    public GalleryComponent save(GalleryComponent galleryComponent) {
        if (galleryComponent.getId() != null) {
            return galleryComponentDAO.update(galleryComponent);
        }
        return galleryComponentDAO.create(galleryComponent);
    }

    @Transactional
    public boolean delete(Long id) {
        return galleryComponentDAO.delete(id);
    }
}
