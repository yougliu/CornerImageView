package com.example.helios.cornerimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by helios on 12/28/15.
 */
public class ImageUtils {

    /**
     * for image
     */

    /**
     * bitmap to drawable
     * @param bitmap
     * @return
     */
    public static Drawable bitmapToDrawable(Bitmap bitmap){
        return new BitmapDrawable(bitmap);
    }

    /**
     * drawable to bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable){
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
//        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565 ;
        Bitmap.Config config = Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,w,h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * resId to bitmap
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap resIdToBitmap(Context context, int resId){
        Drawable drawable = context.getResources().getDrawable(resId);
        return drawableToBitmap(drawable);
    }


}
