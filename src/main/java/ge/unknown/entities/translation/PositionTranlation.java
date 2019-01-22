package ge.unknown.entities.translation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by MJaniko on 3/31/2017.
 */
@Embeddable
public class PositionTranlation {

    @Column(name = "position_en")
    private String positionEN;

    @Column(name = "position_ru")
    private String positionRU;

    public String getPositionEN() {
        return positionEN;
    }

    public void setPositionEN(String positionEN) {
        this.positionEN = positionEN;
    }

    public String getPositionRU() {
        return positionRU;
    }

    public void setPositionRU(String positionRU) {
        this.positionRU = positionRU;
    }
}
