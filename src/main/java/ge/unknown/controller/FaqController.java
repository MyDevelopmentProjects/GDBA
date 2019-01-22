package ge.unknown.controller;

import ge.unknown.entities.Faq;
import ge.unknown.enums.EFaqCategory;
import ge.unknown.service.CategoryService;
import ge.unknown.service.ContactService;
import ge.unknown.service.FaqService;
import ge.unknown.utils.*;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by MJaniko on 5/8/2017.
 */
@Controller
@RequestMapping("/faq")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String faqPage(Model model){
        model.addAttribute("pageTitle", "title.faq");
        model.addAttribute("innerBody", "true");
        model.addAttribute("content", "faq");
        UtilFaq.faqToModel(model, faqService.getByCategory(EFaqCategory.NONE));
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
            @RequestParam(required = false, value = PAGE_NUMBER, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String category) {
        return faqService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize, category);
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody Faq faq) {
        faqService.save(faq);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = faqService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }

}
