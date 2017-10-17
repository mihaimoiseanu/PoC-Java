package ro.mihai.pocjava.data.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Singleton;

import ro.mihai.pocjava.data.models.Photo;
import ro.mihai.pocjava.domain.model.PhotoModel;

/**
 * Created by mihai on 17.10.2017.
 * Mapper class used to transform {@link Photo} (int the data layer) to {@link PhotoModel}
 * in the domain layer
 */
@Singleton
public class PhotoMapper {

    @Inject
    public PhotoMapper() {
    }

    /**
     * Transform a {@link Photo} into a {@link PhotoModel}
     *
     * @param photo Object to be transformed
     * @return {@link PhotoModel} if {@link PhotoModel} otherwise null
     */
    public PhotoModel transform(Photo photo) {
        if (photo == null) {
            return null;
        }
        final PhotoModel photoModel = new PhotoModel();
        photoModel.setPhotoReference(photo.getPhotoReference());
        return photoModel;
    }

    /**
     * Transform a List of {@link Photo} into a Collection of {@link PhotoModel}
     *
     * @param photoCollection Object Collection to be transformed
     * @return {@link PhotoModel} if valid {@link Photo} otherwise empty list
     */
    public Collection<PhotoModel> transform(Collection<Photo> photoCollection) {
        Collection<PhotoModel> photoModelCollection;
        if (photoCollection != null && !photoCollection.isEmpty()) {
            photoModelCollection = new ArrayList<>();
            for (Photo photo : photoCollection) {
                photoModelCollection.add(transform(photo));
            }
        } else {
            photoModelCollection = Collections.emptyList();
        }
        return photoModelCollection;
    }
}
