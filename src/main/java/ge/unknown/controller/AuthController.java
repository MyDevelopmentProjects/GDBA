package ge.unknown.controller;

import ge.unknown.entities.User;
import ge.unknown.security.AuthenticationRequest;
import ge.unknown.security.UserUtils;
import ge.unknown.service.UserService;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static ge.unknown.utils.constants.Constants.ControllerCodes.SLASH;

/**
 * Created by user on 3/17/17.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    @ResponseBody
    public User me(Model model) {
        return UserUtils.currentUser();
    }

    @RequestMapping(value = SLASH + "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RequestResponse register(@RequestBody User user){
        return userService.register(user);
    }

    @RequestMapping(value = "/loginAJAX", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RequestResponse loginAJAX(HttpServletRequest request, @Valid @RequestBody AuthenticationRequest authDet){

        // Perform the authentication
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDet.getUsername(),
                        authDet.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Create a new session and add the security context.
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResponseEntity<?> logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
            SecurityContextHolder.clearContext();
        }
        return ResponseEntity.ok(GeneralUtil.RequestSuccess());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error != null){
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "/security/login";
    }

}
