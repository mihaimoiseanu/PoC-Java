package ro.mihai.pocjava.presentation.views.recyclerviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;

import java.util.List;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.presentation.views.ActionHandler;

import static ro.mihai.pocjava.presentation.utils.DeviceUtils.getScreenWidthPixels;

/**
 * Created by mihai on 17.10.2017.
 */

public class CoverFlowRecyclerView<T> extends RecyclerView {


    public static final float SCALEDOWN_GRAVITY_CENTER = 0.5f;

    private Camera camera;
    private int actionDistance;
    private int maxRotation = 75;
    private float scaleDownGravity = SCALEDOWN_GRAVITY_CENTER;
    private Camera transformationCamera;
    private float unselectedAlpha;
    private float unselectedScale;
    private int itemOffset;
    private int itemLayoutId;
    private Context context;
    private List<T> items;
    protected ActionHandler<T> handler;

    public CoverFlowRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttributes(context, attrs);
        this.setStaticTransformationsEnabled(true);
    }

    private void getAttributes(Context context, AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CoverFlowRecyclerView);
        this.actionDistance = a.getInteger(R.styleable.CoverFlowRecyclerView_actionDistance, Integer.MAX_VALUE);
        this.scaleDownGravity = a.getFloat(R.styleable.CoverFlowRecyclerView_scaleDownGravity, 1.0f);
        this.maxRotation = a.getInteger(R.styleable.CoverFlowRecyclerView_maxRotation, 45);
        this.unselectedAlpha = a.getFloat(R.styleable.CoverFlowRecyclerView_unselectedAlpha, 0.3f);
        this.unselectedScale = a.getFloat(R.styleable.CoverFlowRecyclerView_unselectedScale, 0.75f);
        this.itemOffset = a.getDimensionPixelOffset(R.styleable.CoverFlowRecyclerView_itemOffset, 100);
        String fullLayoutName = a.getString(R.styleable.RecyclerAdapter_itemLayout);
        String layoutName = fullLayoutName.substring(fullLayoutName.lastIndexOf('/') + 1, fullLayoutName.indexOf(".xml"));
        itemLayoutId = context.getResources().getIdentifier(layoutName, "layout", context.getPackageName());
        a.recycle();
    }

    public void setItems(List<T> items) {
        this.items = items;
        if (getLayoutManager() == null) {
            setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
        Parcelable state = getLayoutManager().onSaveInstanceState();
        initAdapter();
        getLayoutManager().onRestoreInstanceState(state);
    }

    private void initAdapter() {
        SingleLayoutRecyclerAdapter<T> adapter = new SingleLayoutRecyclerAdapter<T>(itemLayoutId) {
            @Override
            protected T getObjForPosition(int position) {
                return CoverFlowRecyclerView.this.items.get(position);
            }

            @Override
            public int getItemCount() {
                return CoverFlowRecyclerView.this.items.size();
            }
        };
        adapter.setActionHandler(handler);
        setAdapter(adapter);
        setOnFlingListener(null);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(this);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        child.invalidate();
        int coverFlowWidth = getWidth();
        int coverFlowCenter = coverFlowWidth / 2;
        int childWidth = child.getWidth();
        int childHeight = child.getHeight();
        float effectsAmount = Math.min(1.0f, Math.max(-1.0f, (0.5f / ((float) (this.actionDistance == Integer.MAX_VALUE ? (int) (((float) (coverFlowWidth + childWidth)) / 2.0f) : this.actionDistance))) * ((float) ((getDistance(child) + (childWidth / 2)) - coverFlowCenter))));
        t.clear();
        t.setTransformationType(3);
        if (this.unselectedAlpha != 1.0f) {
            t.setAlpha(((this.unselectedAlpha - 1.0f) * Math.abs(effectsAmount)) + 1.0f);
        }
        Matrix imageMatrix = t.getMatrix();
        if (this.maxRotation != 0) {
            int rotationAngle = (int) ((-effectsAmount) * ((float) this.maxRotation));
            this.transformationCamera.save();
            this.transformationCamera.rotateY((float) rotationAngle);
            this.transformationCamera.getMatrix(imageMatrix);
            this.transformationCamera.restore();
        }
        if (this.unselectedScale != 1.0f) {
            float zoomAmount = ((this.unselectedScale - 1.0f) * Math.abs(effectsAmount)) + 1.0f;
            float translateX = ((float) childWidth) / 2.0f;
            float translateY = ((float) childHeight) * this.scaleDownGravity;
            imageMatrix.preTranslate(-translateX, -translateY);
            imageMatrix.postScale(zoomAmount, zoomAmount);
            imageMatrix.postTranslate(translateX, translateY);
        }
        return true;
    }

    private int getDistance(View view) {
        int parentCenter = getScreenWidthPixels(context) / 2;
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int left = rect.left == 0 ? rect.right - view.getWidth() : rect.left;
        int right = rect.right == getScreenWidthPixels(context) ? rect.left + view.getWidth() : rect.right;
        return (left + (right + left) / 2) - parentCenter;
    }



}
