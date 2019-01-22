package ge.unknown.dao;

import ge.unknown.entities.Role;
import ge.unknown.entities.User;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.pagination.PaginationAndFullSearchQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO extends PaginationAndFullSearchQuery<User> {

    public UserDAO() {
        super(User.class);
    }

    public User findByUserName(String username) {
        List<User> users;
        users = getEntityManager().createQuery("from User where username=:username and active = true")
                .setParameter("username", username)
                .getResultList();
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public User findUserByUsernamePassword(String username, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
        String hashedPassword = passwordEncoder.encode(password);

        List<User> user = getEntityManager().createQuery("FROM User where username=:username and password=:password")
                .setParameter("username", username)
                .setParameter("password", hashedPassword)
                .getResultList();
        if(user != null && user.size() > 0){
            return user.get(0);
        }
        return null;
    }

    public RequestResponse register(User user){
        if(findByUserName(user.getUserName()) != null){
            return GeneralUtil.RequestError("User already exists");
        }
        // Initialize Normal User Access Level
        Role role = new Role();
        role.setId(1L);

        // Set User Role
        user.setRole(role);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.create(user);
        return GeneralUtil.RequestSuccess();
    }

    @Override
    public <T> List<String> getFieldsAvailableForFullTextSearch(Class<T> resultClass) {
        return null;
    }
}
