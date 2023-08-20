package com.apkdoandroid.datavalid_demo;

import android.os.Build;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Java8Base64Image {
    public static void main(String[] args) {
        String imagePath = "C:\\base64\\image.jpg";
        System.out.println("=================Encoder Image to Base 64!=================");
        String base64ImageString = encoder(imagePath);
        System.out.println("Base64ImageString = " + base64ImageString);

        System.out.println("=================Decoder Base64ImageString to Image!=================");
        decoder(base64ImageString, "C:\\base64\\decoderimage.jpg");

        System.out.println("DONE!");

    }

    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                base64Image = Base64.getEncoder().encodeToString(imageData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }

    public static void decoder(String base64Image, String pathFile) {

    }
}