package ge.unknown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MJaniko on 3/28/2017.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @RequestMapping(method = RequestMethod.GET)
    public String search(Model model){
        model.addAttribute("content", "search");
        return "index";
    }
}
