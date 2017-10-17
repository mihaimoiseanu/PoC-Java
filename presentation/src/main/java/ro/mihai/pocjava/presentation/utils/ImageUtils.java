package ro.mihai.pocjava.presentation.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.domain.model.PlaceModel;

/**
 * Created by mihai on 17.10.2017.
 */

public final class ImageUtils {

    private static final String placeHolder = "http://hdimages.org/wp-content/uploads/2017/03/placeholder-image10.jpg";

    private ImageUtils() {
    }

    @BindingAdapter("bind:imgRes")
    public static void loadImage(ImageView imageView, PlaceModel placeModel) {
        String url = (placeModel.getPhotoModels() != null && placeModel.getPhotoModels().size() > 0) ?
                String.format(
                        imageView.getContext().getString(R.string.google_photos_url),
                        DeviceUtils.getScreenWidthPixels(imageView.getContext()),
                        placeModel.getPhotoModels().get(0).getPhotoReference(),
                        imageView.getContext().getString(R.string.google_api_key)) :
                placeHolder;

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .apply(options)
                .into(imageView);

    }

}
