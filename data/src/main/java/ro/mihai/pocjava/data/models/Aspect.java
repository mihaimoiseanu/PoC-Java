package ro.mihai.pocjava.data.models;

/**
 * Created by mihai on 17.10.2017.
 */

public class Aspect {
    private int rating;
    private String type;

    public int getRating() {
        return rating;
    }

    public Aspect setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getType() {
        return type;
    }

    public Aspect setType(String type) {
        this.type = type;
        return this;
    }
}
