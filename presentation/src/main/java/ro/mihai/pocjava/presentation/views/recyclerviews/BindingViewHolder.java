package ro.mihai.pocjava.presentation.views.recyclerviews;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import ro.mihai.pocjava.BR;
import ro.mihai.pocjava.presentation.views.ActionHandler;

/**
 * Created by mihai on 17.10.2017.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final T binding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(final Object item, final ActionHandler handler) {
        binding.setVariable(BR.item);
        binding.setVariable(BR.handler, handler);
        binding.executePendingBindings();

    }

}
