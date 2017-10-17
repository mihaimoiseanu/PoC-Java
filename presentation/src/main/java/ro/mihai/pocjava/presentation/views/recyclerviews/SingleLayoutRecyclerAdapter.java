package ro.mihai.pocjava.presentation.views.recyclerviews;

/**
 * Created by mihai on 17.10.2017.
 */

public abstract class SingleLayoutRecyclerAdapter<T> extends BaseRecyclerAdapter<T> {

    private final int layoutId;

    public SingleLayoutRecyclerAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }
}
