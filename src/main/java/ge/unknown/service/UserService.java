package ge.unknown.service;

import ge.unknown.dao.UserDAO;
import ge.unknown.dto.UserDTO;
import ge.unknown.entities.User;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<UserDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return userDAO.getPaginatedList(User.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(UserDTO.class);
    }

    @Transactional
    public User loadUserByUsername(String username) {
        return userDAO.findByUserName(username);
    }


    @Transactional(readOnly = true)
    public User findUserByUsernamePassword(String username, String password) {
        return userDAO.findUserByUsernamePassword(username,password);
    }

    @Transactional
    public RequestResponse register(User user){
        return userDAO.register(user);
    }


    @Transactional
    public User save(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
        if (user.getId() != null) {
            if(user.getPassword().length() != 60){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return userDAO.update(user);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.create(user);
    }


    @Transactional(readOnly = true)
    public User findById(Long id){
        return userDAO.find(id);
    }

    @Transactional
    public boolean delete(Long id) {
        return userDAO.delete(id);
    }
}
