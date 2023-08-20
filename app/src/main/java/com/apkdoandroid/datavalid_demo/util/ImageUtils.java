package com.apkdoandroid.datavalid_demo.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ImageUtils {

    public static Bitmap scaleBitmap(Bitmap originalBitmap, float scaleFactor) {
        int width = Math.round(originalBitmap.getWidth() * scaleFactor);
        int height = Math.round(originalBitmap.getHeight() * scaleFactor);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, width, height, false);
        return scaledBitmap;
    }

    public static Bitmap resizeBitmap(Bitmap originalBitmap, int newWidth, int newHeight) {
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, false);
        return resizedBitmap;
    }

    public static Bitmap increaseBitmapSize(Bitmap originalBitmap, float scaleFactor) {
        Matrix matrix = new Matrix();
        matrix.postScale(scaleFactor, scaleFactor);

        Bitmap scaledBitmap = Bitmap.createBitmap(
                originalBitmap, 0, 0,
                originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true
        );

        return scaledBitmap;
    }
}

