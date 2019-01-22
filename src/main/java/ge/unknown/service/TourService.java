
package ge.unknown.service;

import ge.unknown.dao.TourDAO;
import ge.unknown.dto.HotelDTO;
import ge.unknown.dto.TourDTO;
import ge.unknown.entities.City;
import ge.unknown.entities.Hotel;
import ge.unknown.entities.Tour;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.SEOUtil;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MJaniko on 3/31/2017.
 */
@Service
public class TourService {

    @Autowired
    private TourDAO tourDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<TourDTO> getSearchList(
            String searchExpression,
            String sortField,
            boolean isAscending,
            Integer pageNumber,
            int pageSize,
            int category,
            int minPrice,
            int maxPrice,
            int adult,
            int child,
            int period,
            String startDate,
            String endDate) {
        return tourDAO.getPaginatedList(Tour.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize,category,minPrice,
                maxPrice,adult,child,period,startDate,endDate
        ).transform(TourDTO.class);
    }

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<TourDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return tourDAO.getPaginatedList(Tour.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(TourDTO.class);
    }

    @Transactional(readOnly = true)
    public List<Tour> getAll(){
        return tourDAO.all();
    }

    @Transactional(readOnly = true)
    public Tour getById(Long id){
        return tourDAO.find(id);
    }

    @Transactional(readOnly = true)
    public List<Tour> getFirstThree(){
        return tourDAO.all().stream().limit(3).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Tour> getToursByCity(Long id, City city){
        return tourDAO.getToursByCity(id, city);
    }

    @Transactional
    public Tour save(Tour tour) {
        tour.setLinks(SEOUtil.generatedSEO(tour.getTranslation()));
        tour.setPeriod(GeneralUtil.getDaysDifference(tour.getStartDate().getTime(), tour.getEndDate().getTime()));
        if (tour.getId() != null) {
            return tourDAO.update(tour);
        }
        return tourDAO.create(tour);
    }

    @Transactional
    public boolean delete(Long id) {
        return tourDAO.delete(id);
    }
}
