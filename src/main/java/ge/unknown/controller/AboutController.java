package ge.unknown.controller;

import ge.unknown.entities.About;
import ge.unknown.entities.Hotel;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static ge.unknown.utils.constants.Constants.ControllerCodes.PUT;
import static ge.unknown.utils.constants.Constants.ControllerCodes.SLASH;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Controller
@RequestMapping("/about-us")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @Autowired
    private SliderService sliderService;

    @RequestMapping(method = RequestMethod.GET)
    public String about(Model model){
        model.addAttribute("content", "about-us");
        model.addAttribute("innerBody", "true");
        model.addAttribute("pageTitle", "title.about-us");
        model.addAttribute("data", aboutService.first());
        model.addAttribute("sliderList", getTopSection(ESliderSection.ABOUT_PAGE_TOP_SECTION));
        return "index";
    }

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    @ResponseBody
    public About about(){
        return aboutService.first();
    }

    private List<Slider> getTopSection(ESliderSection section) {
        List<Slider> list = sliderService.getAll();
        return list.stream().filter(obj-> obj.getSection().equals(section)).collect(Collectors.toList());
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody About about) {
        aboutService.save(about);
        return GeneralUtil.RequestSuccess();
    }
}
