package ge.unknown.controller;

import ge.unknown.entities.About;
import ge.unknown.entities.Slider;
import ge.unknown.enums.ESliderSection;
import ge.unknown.service.*;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.UtilCategory;
import ge.unknown.utils.UtilContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static ge.unknown.utils.constants.Constants.ControllerCodes.PUT;
import static ge.unknown.utils.constants.Constants.ControllerCodes.SLASH;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Controller
@RequestMapping("/members")
public class MembersController {

    @Autowired
    private SliderService sliderService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("pageTitle", "home.partners.title");
        model.addAttribute("content", "members");
        model.addAttribute("topPartnersList", getTopSection(ESliderSection.MEMBERS_PAGE_TOP_SECTION));
        model.addAttribute("partnersList", getTopSection(ESliderSection.MAIN_PAGE_PARTNERS_SECTION));
        return "index";
    }

    private List<Slider> getTopSection(ESliderSection section) {
        List<Slider> list = sliderService.getAll();
        return list.stream().filter(obj-> obj.getSection().equals(section)).collect(Collectors.toList());
    }
}
