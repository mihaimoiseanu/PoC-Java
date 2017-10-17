package ro.mihai.pocjava.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mihai on 17.10.2017.
 */

public class Photo {

    private int height;
    private int width;

    @SerializedName("photo_reference")
    @Expose
    private String photoReference;
    @SerializedName("html_attributions")
    @Expose
    private List<String> htmlAttributions;

    public int getHeight() {
        return height;
    }

    public Photo setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Photo setWidth(int width) {
        this.width = width;
        return this;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public Photo setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
        return this;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public Photo setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
        return this;
    }
}
