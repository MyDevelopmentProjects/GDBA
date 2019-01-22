package ge.unknown.utils;

import ge.unknown.entities.Contact;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by MJaniko on 3/31/2017.
 */
public class UtilContact {
    private static final String CONTACT_IDENTIFIER = "contact";

    public static void contactToModel(Model model, List<Contact> list) {
        if(list == null || list.isEmpty()){
            return;
        }
        for (Contact obj : list) {
            model.addAttribute(CONTACT_IDENTIFIER+obj.getPath(), obj.getDescription());
        }
    }
}
