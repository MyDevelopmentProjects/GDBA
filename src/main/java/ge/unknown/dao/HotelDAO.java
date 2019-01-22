package ge.unknown.dao;

import ge.unknown.entities.City;
import ge.unknown.entities.Hotel;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJaniko on 3/10/2017.
 */
@Repository
public class HotelDAO extends PaginationAndFullSearchQuery<Hotel> {

    public HotelDAO() {
        super(Hotel.class);
    }

    public List<Hotel> getHotelsByCity(Long id,City city){

        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);
        Root<Hotel> returnClassRoot = criteriaQuery.from(Hotel.class);
        returnClassRoot.alias(TABLE_ALIAS);

        criteriaBuilder.and(
                criteriaBuilder.equal(returnClassRoot.get("city").get("id"), city.getId()),
                criteriaBuilder.notEqual(returnClassRoot.get("id"), id));
        criteriaQuery.orderBy(criteriaBuilder.desc(returnClassRoot.get("id")));

        return entityManager.createQuery(criteriaQuery).setMaxResults(5).getResultList();
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        List<String> fieldList = new ArrayList<>();
        if (resultClass == Hotel.class) {
            fieldList.add("description.titleEN");
            fieldList.add("description.titleRU");
        }
        return fieldList;
    }

    @Override
    public <T> Predicate getPDQExpression(Class<T> resultClass, Object... objects) {

        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);
        Root<Hotel> returnClassRoot = criteriaQuery.from(Hotel.class);
        returnClassRoot.alias(TABLE_ALIAS);

        List<Predicate> exprs = new ArrayList<>();

        if(objects != null){
            if (objects.length > 0 && objects[0] instanceof Integer) {
                if((int) objects[0] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("starCount"), objects[0]));
                }
            }

            if (objects.length > 1 && objects[1] instanceof Integer) {
                if((int) objects[1] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("roomCount"), objects[1]));
                }
            }

            if (objects.length > 2 && objects[2] instanceof Integer) {
                if((int) objects[2] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("adultAmount"), objects[2]));
                }
            }

            if (objects.length > 3 && objects[3] instanceof Integer) {
                if((int) objects[3] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("childrenAmount"), objects[3]));
                }
            }


            // Hotel Attributes
            if (objects.length > 4 && objects[4] instanceof Integer) {
                if((int) objects[4] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("att").get("ethernet"), objects[4]));
                }
            }

            if (objects.length > 5 && objects[5] instanceof Integer) {
                if((int) objects[5] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("att").get("restourant"), objects[5]));
                }
            }

            if (objects.length > 6 && objects[6] instanceof Integer) {
                if((int) objects[6] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("att").get("spaServices"), objects[6]));
                }
            }

            if (objects.length > 7 && objects[7] instanceof Integer) {
                if((int) objects[7] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("att").get("swimmingPool"), objects[7]));
                }
            }

            if (objects.length > 8 && objects[8] instanceof Integer) {
                if((int) objects[8] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("att").get("parking"), objects[8]));
                }
            }

            if (objects.length > 9 && objects[9] instanceof Integer) {
                if((int) objects[9] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("att").get("gym"), objects[9]));
                }
            }
        }

        if(exprs.size() > 0){
            return criteriaBuilder.and(exprs.toArray(new Predicate[exprs.size()]));
        }
        return null;
    }
}
