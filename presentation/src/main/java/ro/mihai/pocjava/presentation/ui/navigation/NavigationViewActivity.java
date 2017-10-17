package ro.mihai.pocjava.presentation.ui.navigation;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.view.KeyEvent;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.databinding.NavigationViewBinding;
import ro.mihai.pocjava.presentation.ui.base.BaseActivity;

/**
 * Created by mihai on 17.10.2017.
 */

public abstract class NavigationViewActivity extends BaseActivity {

    private NavigationViewBinding navigationViewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setupActionBarToolbar();
        setupDrawerIcon();
    }

    @Override
    protected ViewDataBinding setupBinding() {
        navigationViewBinding = DataBindingUtil.setContentView(this, R.layout.navigation_view_template);
        return DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), navigationViewBinding.mainContent, true);
    }

    protected boolean isNavDrawerOpen() {
        return navigationViewBinding.drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void setupDrawerIcon() {
        mActionBarToolbar.setNavigationIcon(R.drawable.menu_icon);
        mActionBarToolbar.setNavigationOnClickListener(v -> openNavDrawer());
    }

    protected void toggleDrawer() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            openNavDrawer();
        }
    }

    protected void openNavDrawer() {
        navigationViewBinding.drawerLayout.openDrawer(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        navigationViewBinding.drawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keycode, KeyEvent e) {
        switch (keycode) {
            case KeyEvent.KEYCODE_MENU:
                toggleDrawer();
                return true;
        }
        return super.onKeyDown(keycode, e);
    }
}
