package ge.unknown.service;

import ge.unknown.dao.WhyChooseUsDAO;
import ge.unknown.dto.WhyChooseUsDTO;
import ge.unknown.entities.WhyChooseUs;
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
public class WhyChooseUsService {

    @Autowired
    private WhyChooseUsDAO whyChooseUsDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<WhyChooseUsDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return whyChooseUsDAO.getPaginatedList(WhyChooseUs.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(WhyChooseUsDTO.class);
    }

    @Transactional(readOnly = true)
    public List<WhyChooseUs> getAll(){
        return whyChooseUsDAO.all();
    }

    @Transactional(readOnly = true)
    public List<WhyChooseUs> getFirstThree(){
        return whyChooseUsDAO.all().stream().limit(3).collect(Collectors.toList());
    }

    @Transactional
    public WhyChooseUs save(WhyChooseUs whyChooseUs) {
        if (whyChooseUs.getId() != null) {
            return whyChooseUsDAO.update(whyChooseUs);
        }
        return whyChooseUsDAO.create(whyChooseUs);
    }

    @Transactional
    public boolean delete(Long id) {
        return whyChooseUsDAO.delete(id);
    }

}
