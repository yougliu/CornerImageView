package com.example.helios.cornerimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by helios on 12/28/15.
 */
public class CornerImageView extends ImageView{

    private static final String TAG = CornerImageView.class.getSimpleName();
    private int mLeftTopCorner,mRightTopCorner,mRightBottomCorner,mLeftBottomCorner;

    public CornerImageView(Context context) {
        this(context,null);
    }

    public CornerImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CornerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    /**
     * for set bitmap
     * @param bm
     */
    @Override
    public void setImageBitmap(Bitmap bm) {
        Bitmap bitmap = getCornerBitmap(bm,true,true,true,true);
        super.setImageBitmap(bitmap);
    }


    private Bitmap getCornerBitmap(Bitmap bitmap,boolean leftTop, boolean leftBottom, boolean rightTop, boolean rightBottom){
//        int w = bm.getWidth();
//        int h = bm.getHeight();
//        Bitmap bitmap = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setARGB(0,0,0,0);
//        Rect rect = new Rect(0,0,w,h);
//        Path path = new Path();
//        //lefttop corner
//        RectF leftTop = new RectF(0,0,mLeftTopCorner,mLeftTopCorner);
//        path.arcTo(leftTop,180,90);
//        path.lineTo(w - mRightTopCorner,0);
//
//        //righttop corner
//        RectF rightTop = new RectF(w-mRightTopCorner,0,w,mRightTopCorner);
//        path.arcTo(rightTop,270,90);
//        path.lineTo(w,h-mRightBottomCorner);
//
//        //rightBottom corner
//        RectF rightBottom = new RectF(w-mRightBottomCorner,h-mRightBottomCorner,w,h);
//        path.arcTo(rightBottom,0,90);
//        path.lineTo(mLeftBottomCorner,h);
//
//        //leftBottom corner
//        RectF leftBottom = new RectF(0,h,w-mLeftBottomCorner,h-mLeftBottomCorner);
//        path.arcTo(leftBottom,90,90);
////        path.lineTo(0,mLeftBottomCorner);
//
//        path.close();
//        canvas.drawPath(path,paint);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(bitmap,rect,rect,paint);
//        return bitmap;


        int w = bitmap.getWidth();
        Bitmap output = Bitmap.createBitmap(w, w, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        Rect rect = new Rect(0, 0, w, w);
        paint.setAntiAlias(true);
        Path p = new Path();
        if (leftTop == true) {
            RectF rectF = new RectF(0, 0, w / 10, w / 10);
            p.arcTo(rectF, 180, 90);
        } else {
            p.moveTo(0, 0);
        }
        p.lineTo(w * 19 / 20, 0);
        if (rightTop == true) {
            RectF rectF = new RectF(w * 9 / 10, 0, w, w / 10);
            p.arcTo(rectF, 270, 90);
        } else {
            p.lineTo(w, 0);
        }
        p.lineTo(w, w * 19 / 20);
        if (rightBottom == true) {
            RectF rectF = new RectF(w * 9 / 10, w * 9 / 10, w, w);
            p.arcTo(rectF, 0, 90);
        } else {
            p.lineTo(w, w);
        }
        p.lineTo(w / 20, w);
        if (leftBottom == true) {
            RectF rectF = new RectF(0, w * 9 / 10, w / 10, w);
            p.arcTo(rectF, 90, 90);
        } else {
            p.lineTo(0, w);
        }
        p.close();
        canvas.drawPath(p, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /**
     * bitmap 角度，必须在setImageBitmap前调用
     * @param leftTopCorner
     * @param rightTopCorner
     * @param rightBottomCorner
     * @param leftBottomCorner
     */
    public void setCorner(int leftTopCorner,int rightTopCorner,int rightBottomCorner,int leftBottomCorner){
        this.mLeftTopCorner = leftTopCorner;
        this.mRightTopCorner = rightTopCorner;
        this.mRightBottomCorner = rightBottomCorner;
        this.mLeftBottomCorner = leftBottomCorner;
    }



}
