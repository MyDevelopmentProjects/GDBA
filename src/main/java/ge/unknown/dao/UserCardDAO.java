package ge.unknown.dao;

import ge.unknown.entities.UserCard;
import ge.unknown.security.UserUtils;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJaniko on 4/18/2017.
 */
@Repository
public class UserCardDAO extends PaginationAndFullSearchQuery<UserCard> {

    public UserCardDAO() {
        super(UserCard.class);
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }

    @Override
    public List<UserCard> all(){
        if(!UserUtils.isAuthenticated()){
            return new ArrayList<>();
        }
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserCard> cq = cb.createQuery(UserCard.class);
        Root<UserCard> rootEntry = cq.from(UserCard.class);
        CriteriaQuery<UserCard> all = cq.select(rootEntry).where(
            cb.equal(rootEntry.get("user").get("id"), UserUtils.currentUser().getId())
        );
        TypedQuery<UserCard> allQuery = getEntityManager().createQuery(all);
        List<UserCard> resultList = allQuery.getResultList();
        return  (!resultList.isEmpty())? resultList:new ArrayList<>();
    }
}
