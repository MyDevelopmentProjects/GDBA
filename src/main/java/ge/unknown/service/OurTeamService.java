package ge.unknown.service;

import ge.unknown.dao.OurTeamDAO;
import ge.unknown.dto.OurTeamDTO;
import ge.unknown.entities.OurTeam;
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
public class OurTeamService {

    @Autowired
    private OurTeamDAO ourTeamDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<OurTeamDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return ourTeamDAO.getPaginatedList(OurTeam.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(OurTeamDTO.class);
    }

    @Transactional(readOnly = true)
    public OurTeam find(Long id){
        return ourTeamDAO.find(id);
    }

    @Transactional(readOnly = true)
    public OurTeam first(){
        return ourTeamDAO.first();
    }

    @Transactional(readOnly = true)
    public List<OurTeam> getFirstThree(){
        return ourTeamDAO.all().stream().limit(3).collect(Collectors.toList());
    }

    @Transactional
    public OurTeam save(OurTeam ourTeam) {
        if (ourTeam.getId() != null) {
            return ourTeamDAO.update(ourTeam);
        }
        return ourTeamDAO.create(ourTeam);
    }

    @Transactional
    public boolean delete(Long id) {
        return ourTeamDAO.delete(id);
    }
}
