package com.apkdoandroid.datavalid_demo.demo2;

import static com.google.gson.internal.bind.TypeAdapters.UUID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.apkdoandroid.BED;
import com.apkdoandroid.datavalid_demo.Base64Custom;
import com.apkdoandroid.datavalid_demo.DatavalidAPI;
import com.apkdoandroid.datavalid_demo.MainActivity;
import com.apkdoandroid.datavalid_demo.OnCompleteListener;
import com.apkdoandroid.datavalid_demo.R;
import com.apkdoandroid.datavalid_demo.RetrofitClient;
import com.apkdoandroid.datavalid_demo.databinding.ActivityDemoBinding;
import com.apkdoandroid.datavalid_demo.log.LogUtils;
import com.apkdoandroid.datavalid_demo.model.AnswerBean;
import com.apkdoandroid.datavalid_demo.model.DocumentoBean;
import com.apkdoandroid.datavalid_demo.model.KeyBean;
import com.apkdoandroid.datavalid_demo.model.PF_Facil_CDVResult;
import com.apkdoandroid.datavalid_demo.model.RequestPfFacialCDV;
import com.apkdoandroid.datavalid_demo.util.CameraManagerHelper;
import com.apkdoandroid.datavalid_demo.util.Constantes;
import com.apkdoandroid.datavalid_demo.util.ImageUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kosalgeek.android.imagebase64encoder.ImageBase64;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.graphics.Bitmap;
import android.util.Base64;
public class demoActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int REQUEST_IMAGE_SELFIE = 1;
    private static final int REQUEST_IMAGE_DOC_FRENTE = 2;
    private static final int REQUEST_IMAGE_DOC_VERSO = 3;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private String selfie,doc_frente,doc_verso;
    private ImageView targetImageView; // Variável global para armazenar o ImageView alvo
    private ActivityDemoBinding binding;
    private Uri photoUri;
    private DatavalidAPI service;
    private RequestPfFacialCDV request = new RequestPfFacialCDV();
    private com.apkdoandroid.datavalid_demo.model.KeyBean KeyBean = new KeyBean();
    private AnswerBean answerBean = new AnswerBean();
    private DocumentoBean documentoBean = new DocumentoBean();
    private static final int REQUEST_SAVE_FILE = 103;
    private CameraManagerHelper cameraManagerHelper;

    private static final int REQUEST_CAMERA_PERMISSION = 1;


    private ImageView imageView;
    private Uri imageUri; // Local onde a imagem capturada será salva
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        service = RetrofitClient.classService(DatavalidAPI.class);

        KeyBean.setCpf("02498501258");
        documentoBean.setFormato("JPG");


        // Verifica se a permissão da câmera já foi concedida
        if (
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permissão já concedida, você pode iniciar a câmera aqui
        } else {
            // Solicita permissão para a câmera
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    CAMERA_PERMISSION_CODE);
        }

        binding.imageViewRosto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent(REQUEST_IMAGE_SELFIE,binding.imageViewRosto);
            }
        });
        binding.imageViewDocFrente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent(REQUEST_IMAGE_DOC_FRENTE,binding.imageViewDocFrente);
            }
        });
        binding.imageViewDocTras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent(REQUEST_IMAGE_DOC_VERSO,binding.imageViewDocTras);
            }
        });

        binding.buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Suponha que você já carregou uma imagem no imageView
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cnh_frente);

                // Converta a imagem em base64
                String base64Image = encodeImage(bitmap);
                Log.d("Responde_Datavalid",base64Image);
            }
        });
        binding.buttonEnviarDados.setOnClickListener(new View.OnClickListener() {
            /**
             * ELE TÁ RETORNANDO COD: 422 PORQUE NÃO TA SENDO enviado A IMAGEM facil EM BASE64
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                JsonParser jsonParser = new JsonParser();
                JsonObject json = jsonParser.parse(Constantes.pessoa6CDV).getAsJsonObject();
                KeyBean.setCpf("02498501258");
                documentoBean.setFormato("PNG");
                documentoBean.setBase64(doc_frente);
                answerBean.setDocumento(documentoBean);
                answerBean.setDocumento_verso(documentoBean);
                answerBean.setBiometria_face(documentoBean);
                request.setKey(KeyBean);
                request.setAnswer(answerBean);
               // Log.d("Responde_Datavalid",request.getAnswer().getDocumento().getBase64());
                Call<PF_Facil_CDVResult> call = service.validacaoB_PessoaFisicaFacialCDV(request);
                call.enqueue(new Callback<PF_Facil_CDVResult>() {
                    @Override
                    public void onResponse(Call<PF_Facil_CDVResult> call, Response<PF_Facil_CDVResult> response) {
                        if(response.isSuccessful()){
                            // Log.d("Responde_Datavalid","Serviço funcionando");
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.body().toString());
                        }else{
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.body());
                            Toast.makeText(demoActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PF_Facil_CDVResult> call, Throwable t) {
                        Log.d("Responde_Datavalid","Code: "+t.getMessage());
                        Toast.makeText(demoActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void dispatchTakePictureIntent(int requestCode,ImageView targetImageView) {



       ContentValues values = new ContentValues();
      //  String fileName = "teste.jpg";
      //  values.put(MediaStore.Images.Media.TITLE, fileName);
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri); // Especifica o local para salvar a imagem

        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);


    /*    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }*/
        // Aqui, você pode salvar a referência ao ImageView para atualizá-lo após a captura.
        // Por exemplo, você pode armazenar o ImageView em uma variável de classe.
        this.targetImageView = targetImageView;
    }

    private String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }
   /* private String encodeImage(Bitmap bitmap){
        int previewWidth=150;
        int previewHeight=bitmap.getHeight()*previewWidth/ bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
        byte[] bytes=byteArrayOutputStream.toByteArray();
        return Base64Custom.encodeToString(bytes,Base64Custom.DEFAULT);
    }*/

    private String encodeImage(Bitmap bitmap) {
        bitmap = getResizedBitmap(bitmap, 1449, 1000);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String base64String = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return base64String; // Remove apenas as quebras de linha
    }


    public  void saveImageToGallery(Context context, Bitmap bitmap) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "IMG_" + timeStamp + ".JPEG";

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, imageFileName);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/JPEG");

        // Insere a imagem no MediaStore
        Uri uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        if (uri != null) {
            String imagePath = getImageFilePathFromUri(context, uri);
        //    String imagePath = getImagePath( uri);


            Bitmap bitmaps = BitmapFactory.decodeFile(imagePath);
            binding.imageViewRosto.setImageBitmap(bitmaps);


            try {
                OutputStream outputStream = context.getContentResolver().openOutputStream(uri);
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, outputStream);
                    outputStream.close();
                    Log.d("GallerySaver", "Imagem salva na galeria");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Log.d("Responde_Datavalid", imagePath);
                Base64Custom.encode(imagePath, result -> {
                    LogUtils.saveLogToFile(demoActivity.this, result);
                    Log.d("Responde_Datavalid", result);
                });
                Log.d("Responde_Datavalid", "++++++++++");
            }

          /*  if (imagePath != null) {
                File imageFile = new File(imagePath);
                Log.d("Responde_Datavalid", imagePath); // Aqui está o caminho da imagem
                byte[] bytes = new byte[0];
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    bytes = Files.readAllBytes(Paths.get(imageFile.getPath()));
                }
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    String base64String = java.util.Base64Custom.getEncoder().encodeToString(bytes);
                Log.d("Responde_Datavalid",base64String);
                }

                Log.d("Responde_Datavalid","=================");
            } else {
                Log.d("Responde_Datavalid", "Erro ao obter o caminho da imagem");
            }*/


        }
    }

    public static void saveToFile(Context context, String fileName, String content) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            osw = new OutputStreamWriter(fos);
            osw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getImageFilePathFromUri(Context context, Uri uri) {
        String filePath = null;
        String[] projection = {MediaStore.Images.Media.DATA};

        try (Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                filePath = cursor.getString(columnIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePath;
    }

    public String getImagePath(Uri contentUri) {
        String[] campos = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, campos, null, null, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }

    private long getImageIdFromUri(Uri imageUri) {
        long imageId = -1;

        String[] projection = {MediaStore.Images.Media._ID};
        String selection = MediaStore.Images.Media._ID + " = ?";
        String[] selectionArgs = {String.valueOf(ContentUris.parseId(imageUri))};

        try (Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                null
        )) {
            if (cursor != null && cursor.moveToFirst()) {
                int idColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
                imageId = cursor.getLong(idColumnIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageId;
    }


    private Bitmap getResizedBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK) {
          //  Bundle extras = data.getExtras();
           // Bitmap imageBitmap = (Bitmap) extras.get("data");

          //  Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");


            try {
                Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                getContentResolver().delete(imageUri, null, null); /// remove a imagem salva quando tirei a foto


                imageBitmap = getResizedBitmap(imageBitmap, 1449, 1000);
                // Atualiza o ImageView com a imagem capturada
                if (targetImageView != null) {
                    targetImageView.setImageBitmap(imageBitmap);
                    targetImageView = null; // Limpa a referência após a atualização
                }



                   saveImageToGallery(demoActivity.this,imageBitmap);

                //String base64Image = ImageBase64.with(this).encodeResource(R.drawable.cnh_frente);

                if (imageBitmap != null) {
                    String base64Image = convertBitmapToBase64(imageBitmap);
                  //  String base64Image = encodeImage(imageBitmap);

                    // Converte a imagem capturada em base64
                 // String base64Image = encodeImageToBase64(imageBitmap);
                    Log.d("Responde_Datavalid",base64Image);
                    if (base64Image != null) {
                        // Agora você tem a imagem capturada convertida em base64
                        // Armazene-a ou faça o que quiser com ela
                        if (requestCode == REQUEST_IMAGE_SELFIE) {
                            // Salva na variável de selfie
                            selfie = base64Image;
                            //  documentoBean.setBase64(base64Image);
                            //   answerBean.setBiometria_face(documentoBean);
                            Toast.makeText(this, "Temos o arquivo em base64", Toast.LENGTH_SHORT).show();
                        } else if (requestCode == REQUEST_IMAGE_DOC_FRENTE) {
                            // Salva na variável de documento frente
                            doc_frente = base64Image;
                            //  documentoBean.setBase64(base64Image);
                            // answerBean.setDocumento(documentoBean);
                            //  Log.d("Responde_Datavalid",doc_frente);
                            Toast.makeText(this, "Temos o arquivo em base64", Toast.LENGTH_SHORT).show();
                        } else if (requestCode == REQUEST_IMAGE_DOC_VERSO) {
                            // Salva na variável de documento verso
                            doc_frente = base64Image;
                            //  documentoBean.setBase64(base64Image);
                            // answerBean.setDocumento_verso(documentoBean);
                            Toast.makeText(this, "Temos o arquivo em base64", Toast.LENGTH_SHORT).show();
                        }

                    }

                }else{
                    Toast.makeText(this, "BitMap veio null", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    // Callback para lidar com a resposta da solicitação de permissão
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão concedida, você pode iniciar a câmera aqui
                Toast.makeText(this, "Permissão concedida, Pronto para tirar foto.", Toast.LENGTH_SHORT).show();
            } else {
                // Permissão negada, você pode lidar com isso de acordo com a sua lógica
                Toast.makeText(this, "PErmissão negada", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void imageEncoderDecoder()  {
        try{
            // image path declaration
            String imgPath = "/storage/emulated/0/Pictures/1692465984886.jpg";

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
            String imageString = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                imageString = java.util.Base64.getEncoder().withoutPadding().encodeToString(data);
            }else{
                Log.d("Responde_Datavalid","não roda nesse sdk");
            }

            out.close();
            stream.close();
            //System.out.println("Encode Image Result : " + imageString);
            Log.d("Responde_Datavalid",imageString);
        }catch (Exception e){
            Log.d("Responde_Datavalid",e.getMessage());
        }
    }
}