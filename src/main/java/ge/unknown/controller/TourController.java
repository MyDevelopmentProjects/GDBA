package ge.unknown.controller;

import ge.unknown.entities.Faq;
import ge.unknown.entities.Hotel;
import ge.unknown.entities.Tour;
import ge.unknown.enums.EFaqCategory;
import ge.unknown.service.CategoryService;
import ge.unknown.service.ContactService;
import ge.unknown.service.FaqService;
import ge.unknown.service.TourService;
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
 * Created by MJaniko on 7/3/2017.
 */
@RequestMapping("/tour")
@Controller
public class TourController {

    @Autowired
    private TourService tourService;

    @Autowired
    private FaqService faqService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = SLASH + "{category}" + SLASH + "{seoURL}", method = RequestMethod.GET)
    public String tour(Model model,
                        @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
                        @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
                        @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
                        @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
                        @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
                        @PathVariable("category") int category,
                        @PathVariable("seoURL") String seoURL,
                       @RequestParam(required = false, defaultValue = "0") int minPrice,
                       @RequestParam(required = false, defaultValue = "0") int maxPrice,
                       @RequestParam(required = false, defaultValue = "0") int adult,
                       @RequestParam(required = false, defaultValue = "0") int child,
                       @RequestParam(required = false, defaultValue = "0") int period,
                       @RequestParam(required = false, defaultValue = "0") String startDate,
                       @RequestParam(required = false, defaultValue = "0") String endDate){

        model.addAttribute("content", "tour");
        model.addAttribute("pathVariable", category+"/"+seoURL);
        model.addAttribute("data", tourService.getSearchList(searchExpression, sortField, isAscending, pageNumber,
                pageSize,category,minPrice,maxPrice,adult,child,period,startDate,endDate));
        UtilCategory.categoryToModel(model, categoryService.getAll());
        UtilContact.contactToModel(model, contactService.getAll());
        List<String> jsFiles = new ArrayList<>();
        jsFiles.add("/js/jquery.formstyler.js");
        jsFiles.add("/js/controller/TourController.js");
        JSGeneratorUtil.GenerateJS(model, jsFiles);
        return "index";
    }

    @RequestMapping(value = SLASH + "view" + SLASH + "{tourId}" + SLASH + "{seoURL}", method = RequestMethod.GET)
    public String hotelInnerView(Model model,
                                 @PathVariable("tourId") Long tourId,
                                 @PathVariable("seoURL") String seoURL) {

        Tour tour = tourService.getById(tourId);
        if (tour == null) {
            return "redirect:/";
        }
        List<Faq> faqList = faqService.getByCategory(EFaqCategory.TOUR);
        List<Tour> suggestionList = tourService.getToursByCity(tour.getId(), tour.getCity());
        model.addAttribute("content", "tour-inner");
        model.addAttribute("tourDetails", tour);
        model.addAttribute("suggestions", suggestionList);
        UtilFaq.faqToModel(model, faqList);
        JSGeneratorUtil.GenerateJS(model, "/js/controller/TourController.js");
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
        return tourService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize);
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody Tour tour) {
        tourService.save(tour);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = tourService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }
}
