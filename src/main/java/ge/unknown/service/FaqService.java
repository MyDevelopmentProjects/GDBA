package ge.unknown.service;

import ge.unknown.dao.FaqDAO;
import ge.unknown.dto.FaqDTO;
import ge.unknown.entities.Faq;
import ge.unknown.enums.EFaqCategory;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MJaniko on 4/26/2017.
 */
@Service
public class FaqService {

    @Autowired
    private FaqDAO faqDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<FaqDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize, String category) {
        return faqDAO.getPaginatedList(Faq.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize,category).transform(FaqDTO.class);
    }

    @Transactional(readOnly = true)
    public List<Faq> getAll(){
        return faqDAO.all();
    }

    @Transactional(readOnly =  true)
    public List<Faq> getByCategory(EFaqCategory category){
        return faqDAO.getByCategory(category);
    }

    @Transactional
    public Faq save(Faq faq) {
        if (faq.getId() != null) {
            return faqDAO.update(faq);
        }
        return faqDAO.create(faq);
    }

    @Transactional
    public boolean delete(Long id) {
        return faqDAO.delete(id);
    }
}
