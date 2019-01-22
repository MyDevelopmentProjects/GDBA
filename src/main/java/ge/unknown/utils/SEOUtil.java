package ge.unknown.utils;

import ge.unknown.entities.translation.SEOLinks;
import ge.unknown.entities.translation.TitleDescriptionTranslation;
import ge.unknown.entities.translation.TitleTranslation;

import java.util.regex.Pattern;

/**
 * Created by Mikheil on 3/17/17.
 */
public class SEOUtil {

    private static final int  PATTERN_LENGTH = 20;
    private static final Pattern ENGLISH_TEXT_PTRN = Pattern.compile("");
    private static final Pattern RUSSIAN_TEXT_PTRN = Pattern.compile("");
    private static final Pattern DELIMETERS = Pattern.compile("[\\-| |\\.]+");


    private static String generateSEOString(String url, String lang){
        String ptrn =  url.replaceAll((lang.equals("ru")) ? RUSSIAN_TEXT_PTRN.toString():ENGLISH_TEXT_PTRN.toString(), "");
        ptrn = ptrn.replaceAll(DELIMETERS.toString(), "-");
        if(ptrn.length() > PATTERN_LENGTH){
            return ptrn.substring(0, PATTERN_LENGTH);
        }
        return ptrn;
    }


    public static SEOLinks generatedSEO(TitleTranslation trans){
        SEOLinks seoLinks = new SEOLinks();
        if(trans.getTitleEN() != null && trans.getTitleEN().length() > 0){
            seoLinks.setSeoEN(generateSEOString(trans.getTitleEN(), "en"));
        }
        if(trans.getTitleRU() != null && trans.getTitleRU().length() > 0 ){
            seoLinks.setSeoRU(generateSEOString(trans.getTitleRU(), "ru"));
        }
        if(seoLinks.getSeoEN().length() > 0 && seoLinks.getSeoRU().length() == 0){
            seoLinks.setSeoRU(seoLinks.getSeoRU());
        }
        return seoLinks;
    }

    public static SEOLinks generatedSEO(TitleDescriptionTranslation trans){
        SEOLinks seoLinks = new SEOLinks();
        if(trans.getTitleEN() != null && trans.getTitleEN().length() > 0){
            seoLinks.setSeoEN(generateSEOString(trans.getTitleEN(), "en"));
        }
        if(trans.getTitleRU() != null && trans.getTitleRU().length() > 0 ){
            seoLinks.setSeoRU(generateSEOString(trans.getTitleRU(), "ru"));
        }
        if(seoLinks.getSeoEN().length() > 0 && seoLinks.getSeoRU().length() == 0){
            seoLinks.setSeoRU(seoLinks.getSeoRU());
        }
        return seoLinks;
    }
}
