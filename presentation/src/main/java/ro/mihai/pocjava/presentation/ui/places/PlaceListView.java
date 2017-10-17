package ro.mihai.pocjava.presentation.ui.places;

import java.util.List;

import ro.mihai.pocjava.domain.model.PlaceModel;
import ro.mihai.pocjava.presentation.ui.base.LoadDataView;

/**
 * Created by mihai on 16.10.2017.
 */

public interface PlaceListView extends LoadDataView {

    void renderPlaceList(List<PlaceModel> placeModels);

    void viewPlace(PlaceModel placeModel);

}
