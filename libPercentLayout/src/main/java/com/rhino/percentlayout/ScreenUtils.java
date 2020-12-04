package com.rhino.percentlayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author rhino
 * @since Create on 2020/11/24.
 **/
public class ScreenUtils {

    private static boolean initValid = false;
    private static int widthPixels;
    private static int heightPixels;

    public static void init(Context context) {
        widthPixels = context.getResources().getDimensionPixelSize(R.dimen.previewWidthPixels);
        heightPixels = context.getResources().getDimensionPixelSize(R.dimen.previewHeightPixels);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        if (outMetrics.widthPixels > 0) {
            widthPixels = outMetrics.widthPixels;
            initValid = true;
        }
        if (outMetrics.heightPixels > 0) {
            heightPixels = outMetrics.heightPixels;
            initValid = true;
        }
    }

    public static int getWidthPixels(Context context) {
        if (!initValid) {
            init(context);
        }
        return widthPixels;
    }


    public static int getHeightPixels(Context context) {
        if (!initValid) {
            init(context);
        }
        return heightPixels;
    }

}
