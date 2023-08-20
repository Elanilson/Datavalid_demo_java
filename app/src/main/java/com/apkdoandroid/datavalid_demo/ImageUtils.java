package com.apkdoandroid.datavalid_demo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {


    public static String encodeImageToBase64(String imagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String base64Image = Base64.encodeToString(byteArray, Base64.DEFAULT);

        return base64Image;
    }

    public static String encodeImageBase644(Activity activity, String imagePath, String format, String quality) {
        if (format == null || quality == null || imagePath == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        String mimeType = "image/" + format.toLowerCase();
        String base64Data = convertImageToBase64(imagePath, format, Integer.parseInt(quality));

        if (!base64Data.isEmpty()) {
            Log.d("Responde_Datavalid", base64Data); // Mostra os dados da imagem no log
            return base64Data;
        }

        return "";
    }

    private static String convertImageToBase64(String imagePath, String format, int quality) {
        Bitmap.CompressFormat compressFormat;
        if ("jpeg".equalsIgnoreCase(format)) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        } else if ("png".equalsIgnoreCase(format)) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.WEBP;
        }

        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, quality, byteArrayOutputStream);

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }



}
