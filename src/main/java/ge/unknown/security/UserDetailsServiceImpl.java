package ge.unknown.security;

import ge.unknown.entities.User;
import ge.unknown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 3/16/17.
 */
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.usersService.loadUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No User found with username '%s'.", username));
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            grantedAuthorities.addAll(user.getRole().getPermissions().stream().map(
                    permission -> new SimpleGrantedAuthority(permission.getName())
            ).collect(Collectors.toList()));

            // Load User Role
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

            return new SpringSecurityUser(user,grantedAuthorities);
        }

    }
}
