package ge.unknown.service;

import ge.unknown.dao.CityDAO;
import ge.unknown.dto.CityDTO;
import ge.unknown.entities.City;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Service
public class CityService {

    @Autowired
    private CityDAO countryDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<CityDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return countryDAO.getPaginatedList(City.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(CityDTO.class);
    }
}
