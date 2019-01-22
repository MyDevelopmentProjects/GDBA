package ge.unknown.controller;

import ge.unknown.entities.GalleryComponent;
import ge.unknown.service.GalleryComponentService;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;
import static ge.unknown.utils.constants.Constants.ControllerCodes.DELETE;
import static ge.unknown.utils.constants.Constants.ControllerCodes.SLASH;

/**
 * Created by Mikheil on 7/13/2017.
 */
@Controller
@RequestMapping("/gallery-component")
public class GalleryComponentController {

    @Autowired
    private GalleryComponentService galleryComponentService;

    @RequestMapping(value = SLASH + LIST, method = RequestMethod.GET)
    @ResponseBody
    public PaginationAndFullSearchQueryResult getList(
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
            @RequestParam(required = false, value = PAGE_NUMBER, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String category) {
        return galleryComponentService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize, category);
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody GalleryComponent component) {
        galleryComponentService.save(component);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = galleryComponentService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }
}
