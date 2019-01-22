package ge.unknown.dao;

import ge.unknown.entities.*;
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
public class NewsDAO extends PaginationAndFullSearchQuery<News>{

    public NewsDAO() {
        super(News.class);
    }

    public List<ServiceNews> getServiceNews(){
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceNews> criteriaQuery = criteriaBuilder.createQuery(ServiceNews.class);
        Root<ServiceNews> returnClassRoot = criteriaQuery.from(ServiceNews.class);
        returnClassRoot.alias(TABLE_ALIAS);
        return entityManager.createQuery(criteriaQuery).setMaxResults(4).getResultList();
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }

}
