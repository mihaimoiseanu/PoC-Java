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
 */
@Singleton
public class PhotoMapper {

    @Inject
    public PhotoMapper() {
    }

    public PhotoModel transform(Photo photo) {
        if (photo == null) {
            return null;
        }
        final PhotoModel photoModel = new PhotoModel();
        photoModel.setPhotoReference(photo.getPhotoReference());
        return photoModel;
    }

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
