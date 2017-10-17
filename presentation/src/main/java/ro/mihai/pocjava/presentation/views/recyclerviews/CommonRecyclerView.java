package ro.mihai.pocjava.presentation.views.recyclerviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import java.util.List;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.presentation.views.ActionHandler;

/**
 * Created by mihai on 17.10.2017.
 */

public class CommonRecyclerView<T> extends RecyclerView {

    protected int itemLayoutId;
    protected List<T> items;
    protected ActionHandler<T> handler;

    public CommonRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttributes(context, attrs);
    }

    private void getAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.RecyclerAdapter, 0, 0);
        try {
            String fullLayoutName = a.getString(R.styleable.RecyclerAdapter_itemLayout);
            String layoutName = fullLayoutName.substring(fullLayoutName.lastIndexOf('/') + 1, fullLayoutName.indexOf(".xml"));
            itemLayoutId = context.getResources().getIdentifier(layoutName, "layout", context.getPackageName());
        } catch (Exception e) {
            Log.e("ATTRS", "Attribute parsing error", e);
        } finally {
            a.recycle();
        }
    }

    public void setHandler(ActionHandler<T> handler) {
        this.handler = handler;
    }

    public void setItems(final List<T> items) {
        this.items = items;
        if (getLayoutManager() == null) {
            setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    protected void initCommonAdapter() {
        SingleLayoutRecyclerAdapter<T> adapter = new SingleLayoutRecyclerAdapter<T>(itemLayoutId) {
            @Override
            protected T getObjForPosition(int position) {
                return CommonRecyclerView.this.items.get(position);
            }

            @Override
            public int getItemCount() {
                return CommonRecyclerView.this.items.size();
            }
        };
        adapter.setActionHandler(handler);
        setAdapter(adapter);
    }

}
