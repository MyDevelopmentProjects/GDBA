package ge.unknown.controller;

import ge.unknown.service.ContactService;
import ge.unknown.utils.UtilContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MJaniko on 4/1/2017.
 */
@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    private String gallery(Model model){
        model.addAttribute("pageTitle", "title.gallery");
        model.addAttribute("content", "gallery");
        UtilContact.contactToModel(model, contactService.getAll());
        return "index";
    }

}
