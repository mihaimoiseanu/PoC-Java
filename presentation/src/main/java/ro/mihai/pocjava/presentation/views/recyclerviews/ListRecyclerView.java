package ro.mihai.pocjava.presentation.views.recyclerviews;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by mihai on 17.10.2017.
 */

public class ListRecyclerView<T> extends CommonRecyclerView<T> {


    public ListRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setItems(List<T> items) {
        super.setItems(items);
        Parcelable state = getLayoutManager().onSaveInstanceState();
        initCommonAdapter();
        getLayoutManager().onRestoreInstanceState(state);
    }
}
