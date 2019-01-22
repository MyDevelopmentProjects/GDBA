package ge.unknown.service;

import ge.unknown.dao.UserCardDAO;
import ge.unknown.dto.UserCardDTO;
import ge.unknown.entities.User;
import ge.unknown.entities.UserCard;
import ge.unknown.security.UserUtils;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MJaniko on 4/18/2017.
 */
@Service
public class UserCardService {

    @Autowired
    private UserCardDAO userCardDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<UserCardDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return userCardDAO.getPaginatedList(UserCard.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(UserCardDTO.class);
    }

    @Transactional(readOnly = true)
    public List<UserCard> getAll(){
        return userCardDAO.all();
    }

    @Transactional
    public UserCard save(UserCard userCard) {
        if(!UserUtils.isAdmin()){
            userCard.setUser(UserUtils.currentUser());
        }

        if (userCard.getId() != null) {
            return userCardDAO.update(userCard);
        }
        return userCardDAO.create(userCard);
    }

    @Transactional
    public boolean delete(Long id) {
        if(UserUtils.isAdmin()){
            return userCardDAO.delete(id);
        }

        UserCard card = userCardDAO.find(id);
        User currentUser = UserUtils.currentUser();
        if(card != null && currentUser != null){
            if(card.getUser().getId() == currentUser.getId()){
                return userCardDAO.delete(id);
            }
        }

        return false;
    }
}
