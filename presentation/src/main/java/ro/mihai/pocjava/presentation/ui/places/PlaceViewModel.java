package ro.mihai.pocjava.presentation.ui.places;

import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import ro.mihai.pocjava.BR;
import ro.mihai.pocjava.presentation.model.PlaceModel;
import ro.mihai.pocjava.presentation.ui.base.BaseViewModel;

/**
 * Created by mihai on 17.10.2017.
 */

public class PlaceViewModel extends BaseViewModel {

    private List<PlaceModel> items = new ArrayList<>();

    @Bindable
    public List<PlaceModel> getItems() {
        return items;
    }

    public void setItems(List<PlaceModel> items) {
        this.items = items;
        notifyPropertyChanged(BR.item);
    }


}
