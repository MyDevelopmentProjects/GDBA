package ge.unknown.dao;

import ge.unknown.entities.News;
import ge.unknown.entities.ServiceNews;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Repository
public class ServiceNewsDAO extends PaginationAndFullSearchQuery<ServiceNews> {

    public ServiceNewsDAO() {
        super(ServiceNews.class);
    }

    public ServiceNews updateObj(ServiceNews obj) {
        if (obj.getId() != null) {
            ServiceNews serviceNews = getEntityManager().find(ServiceNews.class, obj.getId());
            serviceNews.setDetails(obj.getDetails());
            serviceNews.setNews(obj.getNews());
            return update(serviceNews);
        }
        return null;
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }

}
