package ro.mihai.pocjava.presentation.ui.base;

import android.app.Fragment;
import android.widget.Toast;

import ro.mihai.pocjava.presentation.di.HasComponent;

/**
 * Created by mihai on 16.10.2017.
 */

public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}
