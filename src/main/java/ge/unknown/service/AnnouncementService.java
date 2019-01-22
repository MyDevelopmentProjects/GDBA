package ge.unknown.service;

import ge.unknown.dao.AnnouncementDAO;
import ge.unknown.dto.AnnouncementDTO;
import ge.unknown.entities.Announcement;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mikheil on 7/7/2017.
 */
@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementDAO announcementDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<AnnouncementDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return announcementDAO.getPaginatedList(Announcement.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(AnnouncementDTO.class);
    }

    @Transactional
    public Announcement save(Announcement announcement){
        if(announcement.getId() != null){
            return announcementDAO.update(announcement);
        }
        return announcementDAO.create(announcement);
    }

    @Transactional(readOnly = true)
    public Announcement findById(Long id){
        return announcementDAO.find(id);
    }

    @Transactional
    public boolean delete(Long id) {
        return announcementDAO.delete(id);
    }
}
