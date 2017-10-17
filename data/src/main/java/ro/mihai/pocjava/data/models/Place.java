package ro.mihai.pocjava.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mihai on 17.10.2017.
 */

public class Place {
    @SerializedName("place_id")
    @Expose
    private String placeId;
    private Double rating;
    private String reference;
    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;
    @SerializedName("formatted_phone_number")
    @Expose
    private String formattedPhoneNumber;
    private Geometry geometry;
    private String icon;
    private String id;
    private OpeningHours openingHours;
    private List<Photo> photos;
    private List<Review> reviews;
    private String scope;
    private List<String> types;
    private String url;
    private String name;
    private String vicinity;
    private String website;

    public String getPlaceId() {
        return placeId;
    }

    public Place setPlaceId(String placeId) {
        this.placeId = placeId;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Place setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public Place setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public Place setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
        return this;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public Place setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
        return this;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Place setGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Place setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getId() {
        return id;
    }

    public Place setId(String id) {
        this.id = id;
        return this;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public Place setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public Place setPhotos(List<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Place setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public Place setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public List<String> getTypes() {
        return types;
    }

    public Place setTypes(List<String> types) {
        this.types = types;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Place setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public Place setName(String name) {
        this.name = name;
        return this;
    }

    public String getVicinity() {
        return vicinity;
    }

    public Place setVicinity(String vicinity) {
        this.vicinity = vicinity;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Place setWebsite(String website) {
        this.website = website;
        return this;
    }
}
