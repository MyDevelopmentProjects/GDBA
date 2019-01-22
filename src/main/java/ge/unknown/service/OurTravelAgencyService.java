package ge.unknown.service;

import ge.unknown.dao.OurTravelAgencyDAO;
import ge.unknown.dto.OurTravelAgencyDTO;
import ge.unknown.entities.OurTravelAgency;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MJaniko on 4/1/2017.
 */
@Service
public class OurTravelAgencyService {

    @Autowired
    private OurTravelAgencyDAO ourTravelAgencyDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<OurTravelAgencyDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return ourTravelAgencyDAO.getPaginatedList(OurTravelAgency.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(OurTravelAgencyDTO.class);
    }

    @Transactional(readOnly = true)
    public OurTravelAgency find(Long id){
        return ourTravelAgencyDAO.find(id);
    }

    @Transactional(readOnly = true)
    public OurTravelAgency first(){
        return ourTravelAgencyDAO.first();
    }

    @Transactional(readOnly = true)
    public List<OurTravelAgency> getFirstThree(){
        return ourTravelAgencyDAO.all().stream().limit(3).collect(Collectors.toList());
    }

    @Transactional
    public OurTravelAgency save(OurTravelAgency ourTravelAgency) {
        if (ourTravelAgency.getId() != null) {
            return ourTravelAgencyDAO.update(ourTravelAgency);
        }
        return ourTravelAgencyDAO.create(ourTravelAgency);
    }

    @Transactional
    public boolean delete(Long id) {
        return ourTravelAgencyDAO.delete(id);
    }
}
