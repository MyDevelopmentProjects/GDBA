package ge.unknown.dao;

import ge.unknown.entities.Faq;
import ge.unknown.enums.EFaqCategory;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJaniko on 4/26/2017.
 */
@Repository
public class FaqDAO extends PaginationAndFullSearchQuery<Faq> {

    public FaqDAO() {
        super(Faq.class);
    }

    @Override
    public <T> Predicate getPDQExpression(Class<T> resultClass, Object... objects) {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Faq> criteriaQuery = criteriaBuilder.createQuery(Faq.class);
        Root<Faq> returnClassRoot = criteriaQuery.from(Faq.class);
        returnClassRoot.alias(TABLE_ALIAS);

        List<Predicate> exprs = new ArrayList<>();

        if(objects != null) {
            if (objects.length > 0 && objects[0] instanceof String) {
                String val = String.valueOf(objects[0]);
                if (val.length() > 0) {
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("category"), EFaqCategory.findByName(val)));
                }
            }
        }

        if(exprs.size() > 0){
            return criteriaBuilder.and(exprs.toArray(new Predicate[exprs.size()]));
        }
        return null;
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }

    public List<Faq> getByCategory(EFaqCategory category){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Faq> cq = cb.createQuery(Faq.class);
        Root<Faq> rootEntry = cq.from(Faq.class);
        CriteriaQuery<Faq> all = cq.select(rootEntry).where(
            cb.equal(rootEntry.get("category"), category)
        );
        TypedQuery<Faq> allQuery = getEntityManager().createQuery(all);
        List<Faq> resultList = allQuery.getResultList();
        return  (!resultList.isEmpty())? resultList:new ArrayList<>();
    }
}