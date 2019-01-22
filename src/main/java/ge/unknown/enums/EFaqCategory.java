package ge.unknown.enums;

/**
 * Created by MJaniko on 4/26/2017.
 */
public enum EFaqCategory {
    NONE,
    HOTEL,
    TOUR;

    public static EFaqCategory findByName(String name){
        for(EFaqCategory dat : values()){
            if(dat.name().equals(name)){
                return dat;
            }
        }
        return null;
    }
}
