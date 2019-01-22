package ge.unknown.utils;

import ge.unknown.entities.Faq;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by Mikheil on 5/5/2017.
 */
public class UtilFaq {
    private static final String FAQ_IDENTIFIER = "faqList";

    public static void faqToModel(Model model, List<Faq> list) {
        if(list == null || list.isEmpty()){
            return;
        }
        model.addAttribute(FAQ_IDENTIFIER, list);
    }
}
