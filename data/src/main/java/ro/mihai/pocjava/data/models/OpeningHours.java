package ro.mihai.pocjava.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mihai on 17.10.2017.
 */

public class OpeningHours {

    @SerializedName("open_now")
    @Expose
    private Boolean openNow;
    private List<Period> periods;
    @SerializedName("weekday_text")
    @Expose
    private List<String> weekdayText;

    public Boolean getOpenNow() {
        return openNow;
    }

    public OpeningHours setOpenNow(Boolean openNow) {
        this.openNow = openNow;
        return this;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public OpeningHours setPeriods(List<Period> periods) {
        this.periods = periods;
        return this;
    }

    public List<String> getWeekdayText() {
        return weekdayText;
    }

    public OpeningHours setWeekdayText(List<String> weekdayText) {
        this.weekdayText = weekdayText;
        return this;
    }
}
