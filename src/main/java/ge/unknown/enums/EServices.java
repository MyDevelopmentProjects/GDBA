package ge.unknown.enums;

/**
 * Created by georgevashakidze on 8/10/17.
 */
public enum EServices {

    LEGISLATION,
    GOVERNMENT,
    CO_OPERATION,
    CREDIT_INFO;

    public static EServices findByName(String name){
        for(EServices dat : values()){
            if(dat.name().equals(name)){
                return dat;
            }
        }
        return null;
    }

}
