package ge.unknown.utils;

import ge.unknown.entities.Category;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by user on 5/29/17.
 */
public class UtilCategory {

    private static final String CATEGORY_IDENTIFIER = "navCategoryList";

    public static void categoryToModel(Model model, List<Category> list) {
        if(list == null || list.isEmpty()){
            return;
        }
        model.addAttribute(CATEGORY_IDENTIFIER, list);
    }
}
