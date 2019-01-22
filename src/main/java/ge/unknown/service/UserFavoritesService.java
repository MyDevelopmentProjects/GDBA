package ge.unknown.service;

import ge.unknown.dao.UserFavoritesDAO;
import ge.unknown.dto.UserFavoritesDTO;
import ge.unknown.entities.UserFavorites;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mikheil on 7/7/2017.
 */
@Service
public class UserFavoritesService {

    @Autowired
    private UserFavoritesDAO userFavoritesDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<UserFavoritesDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return userFavoritesDAO.getPaginatedList(UserFavorites.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(UserFavoritesDTO.class);
    }

    @Transactional
    public UserFavorites save(UserFavorites favorites){
        if(favorites.getId() != null){
            return userFavoritesDAO.update(favorites);
        }
        return userFavoritesDAO.create(favorites);
    }

    @Transactional(readOnly = true)
    public UserFavorites findById(Long id){
        return userFavoritesDAO.find(id);
    }

    @Transactional
    public boolean delete(Long id) {
        return userFavoritesDAO.delete(id);
    }
}
