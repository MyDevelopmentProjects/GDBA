package ge.unknown.controller;

import ge.unknown.dto.ContactMailDTO;
import ge.unknown.entities.Contact;
import ge.unknown.service.CategoryService;
import ge.unknown.service.ContactService;
import ge.unknown.utils.GeneralUtil;
import ge.unknown.utils.RequestResponse;
import ge.unknown.utils.UtilCategory;
import ge.unknown.utils.UtilContact;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static ge.unknown.utils.constants.Constants.ControllerCodes.*;

/**
 * Created by MJaniko on 3/12/2017.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MailSender mailSender;

    @Value("${mail.receiver}")
    private String sendMailTo;

    @RequestMapping(method = RequestMethod.GET)
    public String page(Model model){
        model.addAttribute("pageTitle", "title.contact");
        model.addAttribute("content", "contact");
        UtilCategory.categoryToModel(model, categoryService.getAll());
        UtilContact.contactToModel(model, contactService.getAll());
        return "index";
    }

    @RequestMapping(value = SLASH + "sendMail", method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse sendMail(@RequestBody ContactMailDTO contact){
        StringBuilder msg = new StringBuilder();
        msg.append("FirstName:").append(contact.getFirstName()).append("<br>");
        msg.append("LastName:").append(contact.getLastName()).append("<br>");
        msg.append("Message:").append(contact.getMessage()).append("<br>");
        msg.append("Telephone:").append(contact.getTelephone()).append("<br>");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(sendMailTo);
        mail.setText(msg.toString());

        mailSender.send(mail);

        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + LIST, method = RequestMethod.GET)
    @ResponseBody
    public PaginationAndFullSearchQueryResult getList(
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String searchExpression,
            @RequestParam(required = false, defaultValue = STRING_EMPTY) String sortField,
            @RequestParam(required = false, defaultValue = IS_ASCENDING_DEFAULT_VALUE) boolean isAscending,
            @RequestParam(value = PAGE_NUMBER, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNumber,
            @RequestParam(required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) int pageSize) {
        return contactService.getList(searchExpression, sortField, isAscending, pageNumber, pageSize);
    }

    @RequestMapping(value = SLASH + PUT, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse save(@RequestBody Contact contact) {
        contactService.save(contact);
        return GeneralUtil.RequestSuccess();
    }

    @RequestMapping(value = SLASH + DELETE, method = RequestMethod.POST)
    @ResponseBody
    public RequestResponse delete(@RequestBody Long id) {
        boolean deleted = contactService.delete(id);
        if (deleted) {
            return GeneralUtil.RequestSuccess();
        }
        return GeneralUtil.RequestError();
    }
}
