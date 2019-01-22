package ge.unknown.controller;

import ge.unknown.dto.UserDetailsDTO;
import ge.unknown.entities.User;
import ge.unknown.security.SpringSecurityUser;
import ge.unknown.security.UserUtils;
import ge.unknown.service.CategoryService;
import ge.unknown.service.ContactService;
import ge.unknown.service.UserService;
import ge.unknown.utils.*;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by MJaniko on 3/7/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public String userPage(Model model){
        if(UserUtils.currentUser() == null && !UserUtils.isAuthenticated()){
            return "redirect:/";
        }
        model.addAttribute("user", UserUtils.currentUser());
        model.addAttribute("content", "user-page");
        UtilContact.contactToModel(model, contactService.getAll());
        UtilCategory.categoryToModel(model, categoryService.getAll());
        JSGeneratorUtil.GenerateJS(model, "/js/controller/UserController.js");
        return "index";
    }


    @RequestMapping(value = SLASH + LIST, method = RequestMethod.GET)
    @ResponseBody
    public PaginationAndFullSearchQueryResult getList(
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize) {
        return userService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize);
    }


    @RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse updateUserDetails(Model model, @Valid @RequestBody UserDetailsDTO userDetailsDTO) {
        SpringSecurityUser user = UserUtils.currentUser();
        if(user == null){
            return GeneralUtil.RequestError("Session Timed Out");
        }

        User result = userService.findById(user.getId());
        if(result == null){
            return GeneralUtil.RequestError("Session Timed Out");
        }

        result.setFirstName(userDetailsDTO.getFirstName());
        result.setLastName(userDetailsDTO.getLastName());
        result.setEmail(userDetailsDTO.getEmail());
        result.setPhoneNumber(userDetailsDTO.getPhoneNumber());

        userService.save(result);
        GeneralUtil.reloadUserData(result);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody User user) {
        userService.save(user);
        return GeneralUtil.RequestSuccess();
    }


    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = userService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }
}
