package ro.mihai.pocjava.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mihai on 17.10.2017.
 */

public class Review {

    private List<Aspect> aspects;
    @SerializedName("author_name")
    @Expose
    private String authorName;
    @SerializedName("author_url")
    @Expose
    private String authorUrl;
    private String language;
    private int rating;
    private String text;
    private Long time;

    public List<Aspect> getAspects() {
        return aspects;
    }

    public Review setAspects(List<Aspect> aspects) {
        this.aspects = aspects;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Review setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public Review setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Review setLanguage(String language) {
        this.language = language;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Review setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getText() {
        return text;
    }

    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public Review setTime(Long time) {
        this.time = time;
        return this;
    }
}
