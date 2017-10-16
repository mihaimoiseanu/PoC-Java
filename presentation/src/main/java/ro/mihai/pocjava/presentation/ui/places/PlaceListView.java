package ro.mihai.pocjava.presentation.ui.places;

import java.util.Collection;

import ro.mihai.pocjava.presentation.model.PlaceModel;
import ro.mihai.pocjava.presentation.ui.base.LoadDataView;

/**
 * Created by mihai on 16.10.2017.
 */

public interface PlaceListView extends LoadDataView {

    void renderPlaceList(Collection<PlaceModel> placeModels);

    void viewPlace(PlaceModel placeModel);

}
