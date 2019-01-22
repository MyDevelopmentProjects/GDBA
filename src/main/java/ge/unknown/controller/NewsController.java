package ge.unknown.controller;

import ge.unknown.entities.About;
import ge.unknown.entities.News;
import ge.unknown.entities.ServiceNews;
import ge.unknown.entities.Slider;
import ge.unknown.enums.ESliderSection;
import ge.unknown.service.*;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.UtilCategory;
import ge.unknown.utils.UtilContact;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;
import static ge.unknown.utils.constants.Constants.ControllerCodes.PAGE_NUMBER_DEFAULT_VALUE;
import static ge.unknown.utils.constants.Constants.ControllerCodes.PAGE_SIZE_DEFAULT_VALUE;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private SliderService sliderService;

    @RequestMapping(method = RequestMethod.GET)
    public String news(Model model,
                       @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
                       @RequestParam(required = false, defaultValue = "id") String sortField,
                       @RequestParam(required = false, defaultValue = "false") boolean isAscending,
                       @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
                       @RequestParam(required = false, defaultValue = "6") int pageSize){
        model.addAttribute("content", "news");
        model.addAttribute("innerBody", "true");
        model.addAttribute("pageTitle", "title.news");
        model.addAttribute("sliderList", getTopSection(ESliderSection.NEWS_PAGE_TOP_SECTION));
        model.addAttribute("data", newsService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize));
        return "index";
    }

    @RequestMapping(value = SLASH + "services", method = RequestMethod.GET)
    @ResponseBody
    public List<ServiceNews> getNewsService() {
        return newsService.getServiceNews();
    }

    @RequestMapping(value = SLASH + LIST, method = RequestMethod.GET)
    @ResponseBody
    public PaginationAndFullSearchQueryResult getList(
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize) {
        return newsService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize);
    }

    private List<Slider> getTopSection(ESliderSection section) {
        List<Slider> list = sliderService.getAll();
        return list.stream().filter(obj-> obj.getSection().equals(section)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String more(Model model, @PathVariable("id") Long id, HttpServletRequest request) {

        News n = newsService.find(id);
        if (n == null) {
            return "redirect:/";
        }
        model.addAttribute("content", "more");
        model.addAttribute("data", n);

        String lang = "en";
        Object obj = request.getSession().getAttribute("language");
        if (obj != null) {
            lang = obj.toString();
        }

        model.addAttribute("pageTitle", lang.equals("en") ? n.getDetails().getTitleEN() : n.getDetails().getTitleRU());
        return "index";
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody News news) {
        newsService.save(news);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + "saveService", method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody ServiceNews serviceNews) {
        newsService.save(serviceNews);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = newsService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }
}
