package ro.mihai.pocjava.presentation.views.recyclerviews;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ro.mihai.pocjava.presentation.views.ActionHandler;

/**
 * Created by mihai on 17.10.2017.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {
    protected ActionHandler handler;

    @SuppressWarnings("unchecked")
    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int layoutId) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        T item = getObjForPosition(position);
        holder.bind(item, handler);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract T getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);

    void setActionHandler(ActionHandler<T> handler) {
        this.handler = handler;
    }
}
