package com.apkdoandroid.datavalid_demo.demo2;

import static com.apkdoandroid.datavalid_demo.demo2.demoActivity.getImageFilePathFromUri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.apkdoandroid.datavalid_demo.Base64ImageConverter;
import com.apkdoandroid.datavalid_demo.ImageUtils;
import com.apkdoandroid.datavalid_demo.R;
import com.pixelcarrot.base64image.Base64Image;

import android.util.Base64;

import java.io.ByteArrayOutputStream;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo3Activity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_PICK = 1;

    private ImageView imageView;
    private Button selectButton;
    private Button convertButton;
    private TextView base64TextView;

    private Bitmap selectedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);

        imageView = findViewById(R.id.imageView);
        selectButton = findViewById(R.id.selectButton);
        convertButton = findViewById(R.id.convertButton);
        base64TextView = findViewById(R.id.base64TextView);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedBitmap != null) {
                  //  String base64 = convertBitmapToBase64(selectedBitmap);
                    String base64 = Base64ImageConverter.getBase64Image(imageView);
                    base64TextView.setText("Base64Custom Output:\n" + base64);
                    Log.d("Responde_Datavalid",base64);
                }
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                selectedBitmap = getBitmapFromUri(imageUri);
                imageView.setImageBitmap(selectedBitmap);

                String imagePath = getImageFilePathFromUri(this, imageUri);

                Log.d("Responde_Datavalid",imagePath);

                String filePath = imageUri.getPath();
                try {
                    String result = imageEncoderDecoder(filePath);
                    Log.d("Responde_Datavalid",result);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Lide com quaisquer exceções que possam ocorrer durante o processamento da imagem
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        InputStream inputStream = getContentResolver().openInputStream(uri);
        return BitmapFactory.decodeStream(inputStream);
    }

    private String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);

        return imgString;
    }


    public String  imageEncoderDecoder(String imgPath) {
        String imageString = null;
        try{
            // image path declaration
          //  String imgPath = "download.jpeg";



            // read image from file
            FileInputStream stream = new FileInputStream(imgPath);

            // get byte array from image stream
            int bufLength = 2048;
            byte[] buffer = new byte[2048];
            byte[] data;

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int readLength;
            while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
                out.write(buffer, 0, readLength);
            }

            data = out.toByteArray();

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                imageString = java.util.Base64.getEncoder().withoutPadding().encodeToString(data);
            }

            out.close();
            stream.close();
            System.out.println("Encode Image Result : " + imageString);
        }catch (Exception e){
            Log.d("Responde_Datavalid",e.getMessage());
        }

        return imageString;

    }
}