package ro.mihai.pocjava.presentation.ui.base;

import android.content.Context;

/**
 * Created by mihai on 16.10.2017.
 */

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError(String error);

    Context context();

}
