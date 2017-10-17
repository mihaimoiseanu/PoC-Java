package ro.mihai.pocjava.data.models;

/**
 * Created by mihai on 17.10.2017.
 */

public class Period {
    private OpeningHour open;
    private OpeningHour close;

    public OpeningHour getOpen() {
        return open;
    }

    public Period setOpen(OpeningHour open) {
        this.open = open;
        return this;
    }

    public OpeningHour getClose() {
        return close;
    }

    public Period setClose(OpeningHour close) {
        this.close = close;
        return this;
    }
}
