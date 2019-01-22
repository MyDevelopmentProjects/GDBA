package ge.unknown.controller;

import ge.unknown.entities.Faq;
import ge.unknown.entities.Hotel;
import ge.unknown.enums.EFaqCategory;
import ge.unknown.service.CategoryService;
import ge.unknown.service.ContactService;
import ge.unknown.service.FaqService;
import ge.unknown.service.HotelService;
import ge.unknown.utils.*;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by MJaniko on 3/10/2017.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private FaqService faqService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String hotel(Model model,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = "0") int starCount,
            @RequestParam(required = false, defaultValue = "0") int roomCount,
            @RequestParam(required = false, defaultValue = "0") int adultAmount,
            @RequestParam(required = false, defaultValue = "0") int childrenAmount,
            @RequestParam(required = false, defaultValue = "0") int ethernet,
            @RequestParam(required = false, defaultValue = "0") int restourant,
            @RequestParam(required = false, defaultValue = "0") int spaServices,
            @RequestParam(required = false, defaultValue = "0") int swimmingPool,
            @RequestParam(required = false, defaultValue = "0") int parking,
            @RequestParam(required = false, defaultValue = "0") int gym) {

        model.addAttribute("content", "hotel");
        model.addAttribute("data", hotelService.getSearchList(searchExpression, sortField, isAscending, pageNumber,
            pageSize,starCount,roomCount,adultAmount,childrenAmount, ethernet,restourant,spaServices,swimmingPool,
            parking,gym
        ));
        UtilCategory.categoryToModel(model, categoryService.getAll());
        UtilContact.contactToModel(model, contactService.getAll());
        return "index";
    }

    @RequestMapping(value = SLASH + "view" + SLASH + "{hotelId}" + SLASH + "{seoURL}", method = RequestMethod.GET)
    public String hotelInnerView(Model model,
                                 @PathVariable("hotelId") Long hotelId,
                                 @PathVariable("seoURL") String seoURL) {

        Hotel hotel = hotelService.getById(hotelId);
        if (hotel == null) {
            return "redirect:/";
        }
        List<Faq> faqList = faqService.getByCategory(EFaqCategory.HOTEL);
        List<Hotel> suggestionList = hotelService.getHotelsByCity(hotel.getId(),hotel.getCity());
        model.addAttribute("content", "hotel-inner");
        model.addAttribute("hotelDetails", hotel);
        model.addAttribute("suggestions", suggestionList);
        UtilFaq.faqToModel(model, faqList);

        List<String> jsFiles = new ArrayList<>();
        jsFiles.add("http://maps.google.com/maps/api/js?sensor=false");
        jsFiles.add("/js/controller/HotelController.js");
        JSGeneratorUtil.GenerateJS(model, jsFiles);
        UtilCategory.categoryToModel(model, categoryService.getAll());
        UtilContact.contactToModel(model, contactService.getAll());
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
        return hotelService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize);
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = hotelService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }
}
