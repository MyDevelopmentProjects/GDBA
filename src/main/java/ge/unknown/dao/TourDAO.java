package ge.unknown.dao;

import ge.unknown.entities.City;
import ge.unknown.entities.Hotel;
import ge.unknown.entities.Tour;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.*;

/**
 * Created by MJaniko on 3/31/2017.
 */
@Repository
public class TourDAO extends PaginationAndFullSearchQuery<Tour> {

    public TourDAO() {
        super(Tour.class);
    }

    public List<Tour> getToursByCity(Long id, City city){
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = criteriaBuilder.createQuery(Tour.class);
        Root<Tour> returnClassRoot = criteriaQuery.from(Tour.class);
        returnClassRoot.alias(TABLE_ALIAS);

        criteriaBuilder.and(
                criteriaBuilder.equal(returnClassRoot.get("city").get("id"), city.getId()),
                criteriaBuilder.notEqual(returnClassRoot.get("id"), id));
        criteriaQuery.orderBy(criteriaBuilder.desc(returnClassRoot.get("id")));

        return entityManager.createQuery(criteriaQuery).setMaxResults(5).getResultList();
    }

    @Override
    public <T> Predicate getPDQExpression(Class<T> resultClass, Object... objects) {

        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = criteriaBuilder.createQuery(Tour.class);
        Root<Tour> returnClassRoot = criteriaQuery.from(Tour.class);
        returnClassRoot.alias(TABLE_ALIAS);

        List<Predicate> exprs = new ArrayList<>();

        if(objects != null){
            if (objects.length > 0 && objects[0] instanceof Integer) {
                if((int) objects[0] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("category").get("id"), objects[0]));
                }
            }

            // price Min
            if (objects.length > 1 && objects[1] instanceof Integer) {
                int val =(int) objects[1];
                if(val > 0){
                    exprs.add(criteriaBuilder.greaterThan(returnClassRoot.get("price"), val));
                }
            }

            // price Max
            if (objects.length > 2 && objects[2] instanceof Integer) {
                int val =(int) objects[2];
                if(val > 0){
                    exprs.add(criteriaBuilder.lessThan(returnClassRoot.get("price"), val));
                }
            }

            if (objects.length > 3 && objects[3] instanceof Integer) {
                if((int) objects[3] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("adult"), objects[3]));
                }
            }

            if (objects.length > 4 && objects[4] instanceof Integer) {
                if((int) objects[4] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("child"), objects[4]));
                }
            }

            if (objects.length > 5 && objects[5] instanceof Integer) {
                if((int) objects[5] > 0){
                    exprs.add(criteriaBuilder.equal(returnClassRoot.get("period"), objects[5]));
                }
            }

            // min Date
            if (objects.length > 6 && objects[6] instanceof String) {
                String dateVal = (String) objects[6];
                if(!dateVal.equals("0")){
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        Date startDate = format.parse(dateVal);
                        exprs.add(criteriaBuilder.greaterThanOrEqualTo(returnClassRoot.get("startDate"), startDate));
                    } catch (Exception e){
                        System.out.println("Exception:"+e);
                    }
                }
            }

            if (objects.length > 7 && objects[7] instanceof String) {
                String dateVal = (String) objects[7];
                if(!dateVal.equals("0")){
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        Date endDate = format.parse(dateVal);
                        exprs.add(criteriaBuilder.lessThanOrEqualTo(returnClassRoot.get("endDate"), endDate));
                    } catch (Exception e){
                        System.out.println("Exception:"+e);
                    }
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
        List<String> fieldList = new ArrayList<>();
        if (resultClass == Tour.class) {
            fieldList.add("translation.titleEN");
            fieldList.add("translation.titleRU");
        }
        return fieldList;
    }
}
