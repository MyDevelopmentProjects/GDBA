package ge.unknown.controller;

import ge.unknown.entities.UserCard;
import ge.unknown.service.UserCardService;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by MJaniko on 4/18/2017.
 */
@Controller
@RequestMapping("/user-card")
public class UserCardController {

    @Autowired
    private UserCardService userCardService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = SLASH + LIST, method = RequestMethod.GET)
    @ResponseBody
    public PaginationAndFullSearchQueryResult getList(
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize) {
        return userCardService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize);
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody UserCard userCard) {
        userCardService.save(userCard);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = userCardService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }

}
