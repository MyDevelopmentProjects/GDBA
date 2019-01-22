package ge.unknown.service;

import ge.unknown.dao.CategoryDAO;
import ge.unknown.dto.CategoryDTO;
import ge.unknown.entities.Category;
import ge.unknown.utils.SEOUtil;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<CategoryDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return categoryDAO.getPaginatedList(Category.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(CategoryDTO.class);
    }


    @Transactional(readOnly = true)
    public List<Category> getAll(){
        return categoryDAO.all();
    }


    @Transactional
    public Category save(Category category) {
        category.setSeoURL(SEOUtil.generatedSEO(category.getTitles()));
        if (category.getId() != null) {
            return categoryDAO.update(category);
        }
        return categoryDAO.create(category);
    }

    @Transactional
    public boolean delete(Long id) {
        return categoryDAO.delete(id);
    }
}
