package ge.unknown.service;

import ge.unknown.dao.NewsDAO;
import ge.unknown.dao.ServiceNewsDAO;
import ge.unknown.dto.TourDTO;
import ge.unknown.entities.News;
import ge.unknown.entities.ServiceNews;
import ge.unknown.entities.Tour;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Service
public class NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Autowired
    private ServiceNewsDAO serviceNewsDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return newsDAO.getPaginatedList(News.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize);
    }

    public List<ServiceNews> getServiceNews() {
        return newsDAO.getServiceNews();
    }

    @Transactional(readOnly = true)
    public News find(Long id){
        return newsDAO.find(id);
    }

    @Transactional(readOnly = true)
    public List<News> getLastX(int number){
        return newsDAO.lastX(number);
    }

    @Transactional
    public News save(News about) {
        if (about.getId() != null) {
            return newsDAO.update(about);
        }
        return newsDAO.create(about);
    }

    @Transactional
    public ServiceNews save(ServiceNews serviceNews) {
        return serviceNewsDAO.updateObj(serviceNews);
    }

    @Transactional
    public boolean delete(Long id) {
        return newsDAO.delete(id);
    }
}
