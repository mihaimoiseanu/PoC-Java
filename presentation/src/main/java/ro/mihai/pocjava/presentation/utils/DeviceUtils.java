package ro.mihai.pocjava.presentation.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by mihai on 17.10.2017.
 */

public final class DeviceUtils {

    private DeviceUtils(){}

    public static int getScreenWidthPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;

    }
}
