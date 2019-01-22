package ge.unknown.controller;

import ge.unknown.entities.Slider;
import ge.unknown.entities.Tour;
import ge.unknown.enums.ESliderSection;
import ge.unknown.security.UserUtils;
import ge.unknown.service.*;
import ge.unknown.utils.UtilCategory;
import ge.unknown.utils.UtilContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MJaniko on 3/10/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private SliderService sliderService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("content", "main");
        model.addAttribute("pageTitle", "title.home");
        model.addAttribute("partnersList", getTopSection(ESliderSection.MAIN_PAGE_PARTNERS_SECTION));
        model.addAttribute("sliderList", getTopSection(ESliderSection.MAIN_PAGE_TOP_SECTION));
        model.addAttribute("last9news", newsService.getLastX(9));
        model.addAttribute("serviceNews", newsService.getServiceNews());
        UtilContact.contactToModel(model, contactService.getAll());
        return "index";
    }

    private List<Slider> getTopSection(ESliderSection section) {
        List<Slider> list = sliderService.getAll();
        return list.stream().filter(obj-> obj.getSection().equals(section)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "security/index";
    }
}

