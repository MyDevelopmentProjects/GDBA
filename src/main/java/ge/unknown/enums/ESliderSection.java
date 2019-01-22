package ge.unknown.enums;

/**
 * Created by georgevashakidze on 8/6/17.
 */
public enum ESliderSection {

    MAIN_PAGE_TOP_SECTION,
    MAIN_PAGE_NEWS_SECTION,
    MAIN_PAGE_PARTNERS_SECTION,
    ABOUT_PAGE_TOP_SECTION,
    NEWS_PAGE_TOP_SECTION,
    MEMBERS_PAGE_TOP_SECTION;

    public static ESliderSection findByName(String name){
        for(ESliderSection dat : values()){
            if(dat.name().equals(name)){
                return dat;
            }
        }
        return null;
    }

}
