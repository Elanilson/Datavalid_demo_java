package com.apkdoandroid.datavalid_demo.appDemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.apkdoandroid.datavalid_demo.Base64Custom;
import com.apkdoandroid.datavalid_demo.DatavalidAPI;
import com.apkdoandroid.datavalid_demo.R;
import com.apkdoandroid.datavalid_demo.RetrofitClient;
import com.apkdoandroid.datavalid_demo.databinding.ActivityAppBinding;
import com.apkdoandroid.datavalid_demo.demo2.demoActivity;
import com.apkdoandroid.datavalid_demo.log.LogUtils;
import com.apkdoandroid.datavalid_demo.model.AnswerBean;
import com.apkdoandroid.datavalid_demo.model.ApiResponse;
import com.apkdoandroid.datavalid_demo.model.DocumentoBean;
import com.apkdoandroid.datavalid_demo.model.KeyBean;
import com.apkdoandroid.datavalid_demo.model.PF_Facil_CDVResult;
import com.apkdoandroid.datavalid_demo.model.RequestPfFacialCDV;
import com.apkdoandroid.datavalid_demo.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int REQUEST_IMAGE_SELFIE = 1;
    private static final int REQUEST_IMAGE_DOC_FRENTE = 2;
    private static final int REQUEST_IMAGE_DOC_VERSO = 3;
    private ImageView targetImageView; // Variável global para armazenar o ImageView alvo
    private Uri imageUri; // Local onde a imagem capturada será salva
    private String selfie,doc_frente,doc_verso;

    private RequestPfFacialCDV request = new RequestPfFacialCDV();
    private KeyBean keyBean = new KeyBean();
    private AnswerBean answerBean = new AnswerBean();
    private DocumentoBean documentoBean = new DocumentoBean();
    private DatavalidAPI service;
    private ActivityAppBinding binding;

    private Dialog dialog ;
    private Button buttonConfirmarDialog;
    private TextView textViewMensagem;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        service = RetrofitClient.classService(DatavalidAPI.class);
        dialog = new Dialog(this);
        dialogCustomInfo();

        binding.editTextCPF.setText("11295395045");

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

        binding.buttonEnviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf = binding.editTextCPF.getText().toString();
                if(cpf == null || cpf.isEmpty()){
                    Toast.makeText(AppActivity.this, "Informe o CPF.", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.show();

                // Suponha que você já carregou uma imagem no imageView

                LogUtils.saveLogToFile(AppActivity.this, selfie);
                LogUtils.saveLogToFile(AppActivity.this, doc_frente);
                LogUtils.saveLogToFile(AppActivity.this, doc_verso);
                keyBean.setCpf(cpf);
                enviarEndPointA(selfie,doc_frente,doc_verso);
            }
        });

        binding.buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf = binding.editTextCPF.getText().toString();
                if(cpf == null || cpf.isEmpty()){
                    cpf = "11295395045";
                    binding.editTextCPF.setText(cpf);
                }

                dialog.show();
                // Suponha que você já carregou uma imagem no imageView
                Bitmap bitmapUser = BitmapFactory.decodeResource(getResources(), R.drawable.foto_user);
                Bitmap bitmapCNHFrente = BitmapFactory.decodeResource(getResources(), R.drawable.cnh_frente);
                Bitmap bitmapCNHVErso = BitmapFactory.decodeResource(getResources(), R.drawable.cnh_verso);

                String base64User = convertBitmapToBase64(bitmapUser);
                LogUtils.saveLogToFile(AppActivity.this, "Face"+base64User);
                String baseCNHFrente = convertBitmapToBase64(bitmapCNHFrente);
                LogUtils.saveLogToFile(AppActivity.this, baseCNHFrente);
                String base64CNHVErso = convertBitmapToBase64(bitmapCNHVErso);
                LogUtils.saveLogToFile(AppActivity.this, base64CNHVErso);
                keyBean.setCpf(cpf);
               // enviarEndPoint(base64User,baseCNHFrente,base64CNHVErso);
                enviarEndPointA(base64User,baseCNHFrente,base64CNHVErso);
            }
        });

    }

    private void showBottomDialog(PF_Facil_CDVResult pfDoc) {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);
        TextView textVie_documento                       = dialog.findViewById(R.id.textdocumento);
        TextView textVie_numero_registro                 = dialog.findViewById(R.id.textViewnumero_registro);
        TextView textVie_numero_registro_ocr             = dialog.findViewById(R.id.textViewnumero_registro_ocr);
        TextView textVie_nome                            = dialog.findViewById(R.id.textViewnome);
        TextView textVie_nome_similaridade               = dialog.findViewById(R.id.textViewnome_similaridade);
        TextView textVie_nome_ocr                        = dialog.findViewById(R.id.textViewnome_ocr);
        TextView textVie_identidade                      = dialog.findViewById(R.id.textViewidentidade);
        TextView textVie_identidade_similaridade         = dialog.findViewById(R.id.textViewidentidade_similaridade);
        TextView textVie_identidade_ocr                  = dialog.findViewById(R.id.textViewidentidade_ocr);
        TextView textVie_data_nascimento                 = dialog.findViewById(R.id.textViewdata_nascimento);
        TextView textVie_data_nascimento_ocr             = dialog.findViewById(R.id.textViewdata_nascimento_ocr);
        TextView textVie_data_primeira_habilitacao       = dialog.findViewById(R.id.textViewdata_primeira_habilitacao);
        TextView textVie_data_primeira_habilitacao_ocr   = dialog.findViewById(R.id.textViewdata_primeira_habilitacao_ocr);
        TextView textVie_data_ultima_emissao             = dialog.findViewById(R.id.textViewdata_ultima_emissao);
        TextView textVie_data_ultima_emissao_ocr         = dialog.findViewById(R.id.textViewdata_ultima_emissao_ocr);
        TextView textVie_data_validade                   = dialog.findViewById(R.id.textViewdata_validade);
        TextView textVie_data_validade_ocr               = dialog.findViewById(R.id.textViewdata_validade_ocr);
        TextView textVie_disponivel_retrato              = dialog.findViewById(R.id.textViewdisponivelretrato);
        TextView textVie_probabilidade_retrato           = dialog.findViewById(R.id.textViewprobabilidaderetrato);
        TextView textVie_similaridade_retrato            = dialog.findViewById(R.id.textViewsimilaridaderetrato);
        TextView textVie_disponivel_biometria_face       = dialog.findViewById(R.id.textViewdisponivelbiometria_face);
        TextView textVie_probabilidade_biometria_face    = dialog.findViewById(R.id.textViewprobabilidadebiometria_face);
        TextView textVie_similaridade_biometria_face     = dialog.findViewById(R.id.textViewsimilaridadebiometria_face);

        textVie_documento                       .setText("Documento: "+pfDoc.getDocumento());
        textVie_numero_registro                 .setText("NumeroReg: "+pfDoc.getCnh().isNumero_registro());
        textVie_numero_registro_ocr             .setText("Numero registro_ocr: \n "+pfDoc.getCnh().getNumero_registro_ocr());
        textVie_nome                            .setText("nome: "+pfDoc.getCnh().isNome());
        textVie_nome_similaridade               .setText("Nome similaridade:  \n "+pfDoc.getCnh().getNome_similaridade());
        textVie_nome_ocr                        .setText("Nome_ocr: \n "+pfDoc.getCnh().getNome_ocr());
        textVie_identidade                      .setText("Identidade:  "+pfDoc.getCnh().isIdentidade());
        textVie_identidade_similaridade         .setText("Identidade similaridade: \n "+pfDoc.getCnh().getIdentidade_similaridade());
        textVie_identidade_ocr                  .setText("Identidade_ocr:  \n "+pfDoc.getCnh().getIdentidade_ocr());
        textVie_data_nascimento                 .setText("Data nascimento: \n "+pfDoc.getCnh().isData_nascimento());
        textVie_data_nascimento_ocr             .setText("Data nascimento_ocr: \n "+pfDoc.getCnh().getData_nascimento_ocr());
        textVie_data_primeira_habilitacao       .setText("Data primeira habilitacao: \n "+pfDoc.getCnh().isData_primeira_habilitacao());
        textVie_data_primeira_habilitacao_ocr   .setText("Data primeira habilitacao_ocr:  \n "+pfDoc.getCnh().getData_primeira_habilitacao_ocr());
        textVie_data_ultima_emissao             .setText("Data ultima emissao: \n "+pfDoc.getCnh().isData_ultima_emissao());
        textVie_data_ultima_emissao_ocr         .setText("Data ultima emissao_ocr: \n "+pfDoc.getCnh().getData_ultima_emissao_ocr());
        textVie_data_validade                   .setText("data validade: "+pfDoc.getCnh().isData_validade());
        textVie_data_validade_ocr               .setText("Data validade_ocr: \n "+pfDoc.getCnh().getData_validade_ocr());
        textVie_disponivel_retrato              .setText("Disponivel: "+pfDoc.getCnh().getRetrato().isDisponivel());
        textVie_probabilidade_retrato           .setText("Probabilidade: \n "+pfDoc.getCnh().getRetrato().getProbabilidade());
        textVie_similaridade_retrato            .setText("Similaridade: \n "+pfDoc.getCnh().getRetrato().getSimilaridade());
        textVie_disponivel_biometria_face       .setText("Disponivel: "+pfDoc.getBiometria_face().isDisponivel());
        textVie_probabilidade_biometria_face    .setText("Probabilidade: \n "+pfDoc.getBiometria_face().getProbabilidade());
        textVie_similaridade_biometria_face     .setText("Similaridade: \n"+pfDoc.getBiometria_face().getSimilaridade());

        videoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(AppActivity.this,"Upload a Video is clicked",Toast.LENGTH_SHORT).show();

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(AppActivity.this,"Create a short is Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(AppActivity.this,"Go live is Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    private void dialogCustomInfo(){
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_info);
        TextView textViewInfo = dialog.findViewById(R.id.textViewDialogInfo);
        buttonConfirmarDialog = dialog.findViewById(R.id.buttondialogConfirmar);
        textViewMensagem = dialog.findViewById(R.id.textViewDialogInfo);
        progressBar = dialog.findViewById(R.id.progressBarDialog);
        textViewInfo.setText("Carregando...");

        buttonConfirmarDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInfo.setText("Carregando...");
                buttonConfirmarDialog.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                dialog.dismiss();

            }
        });

        // Definir tamanho da janela para ocupar todo espaço horizontal
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(layoutParams);
      //  dialog.create();

    }
    private  void dialogButtonHiderOrShow(){
        if(buttonConfirmarDialog.GONE == View.GONE){
            buttonConfirmarDialog.setVisibility(View.VISIBLE);
        }else{
            buttonConfirmarDialog.setVisibility(View.GONE);
        }
    }
    private void dialogMensagem(String mensagem){
        textViewMensagem.setText(mensagem);
        buttonConfirmarDialog.setVisibility(View.VISIBLE);
    }

    private void dialogProgressBarHider(){
        progressBar.setVisibility(View.GONE);
    }
    private void enviarEndPointA(String biometricaFacial, String docFrente, String docVerso){
        // JsonParser jsonParser = new JsonParser();
        // JsonObject json = jsonParser.parse(Constantes.pessoa6CDV).getAsJsonObject();
        //keyBean.setCpf("11295395045");

        //documentoBean.setBase64(doc_frente);
        answerBean.setDocumento(new DocumentoBean("JPG",docFrente));
        answerBean.setDocumento_verso(new DocumentoBean("JPG",docVerso));
        answerBean.setBiometria_face(new DocumentoBean("JPG",biometricaFacial));
        request.setKey(keyBean);
        request.setAnswer(answerBean);
        // Log.d("Responde_Datavalid",request.getAnswer().getDocumento().getBase64());
        Call<PF_Facil_CDVResult>  call = service.validacaoB_PessoaFisicaFacialCDV(request);
        call.enqueue(new Callback<PF_Facil_CDVResult>() {
            @Override
            public void onResponse(Call<PF_Facil_CDVResult> call, Response<PF_Facil_CDVResult> response) {
                dialogProgressBarHider();
                if(response.isSuccessful() && response.body() != null){
                    dialog.dismiss();

                    showBottomDialog(response.body());


                    Log.d("Responde_Datavalid","1Code: "+response.code()+" - "+response.body().toString());
                }else{
                    String errorBodyString = null;
                    try {
                         errorBodyString = response.errorBody().source().readUtf8();
                      //  errorBodyString = response.errorBody().toString();

                        // Converter a string JSON em um array JSON
                        JSONArray jsonArray = new JSONArray(errorBodyString);
                        String message = "";
                        String code = "";

                        // Percorrer o array e extrair os objetos individuais
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            // Verificar se o campo "id" existe no objeto JSON
                            if (jsonObject.has("code")) {
                                // Extrair os valores dos campos
                                code = jsonObject.getString("code");

                            }
                            if(jsonObject.has("message")) {
                                // Extrair os valores dos campos
                                message = jsonObject.getString("message");
                            }

                            // Fazer o que quiser com os valores obtidos
                            // Por exemplo, exibir no log
                            Log.d("Responde_Datavalid", "Item " + code + ": " + message);
                        }

                        String msg = "Code: "+code+" \n"+
                                "Message: "+message;

                        dialogMensagem(msg);

                        Log.d("Responde_Datavalid","2Code: "+response.code()+" - "+errorBodyString.toString() );
                        //  Log.d("Responde_Datavalid","2Code: "+response.code()+" - "+errorBodyString );
                   /* } catch (IOException e) {
                        dialogMensagem(e.getMessage());
                        Log.d("Responde_Datavalid","2Code: "+e.getMessage() );*/

                    } catch (JSONException e) {
                        String msgErro = "cannot be converted to JSONArray";

                        dialogMensagem("Ops! Sem resposta \n  TimeOut");

                        Log.d("Responde_Datavalid","JSONException "+e.getMessage() );
                    }catch (RuntimeException e){
                        dialogMensagem("Ops! Algo deu errado runtimeRuntime. \n "+e.getMessage());
                        Log.d("Responde_Datavalid","RuntimeException "+e.getMessage() );
                    }catch (Exception e){
                        dialogMensagem("Ops! Algo deu errado. \n "+e.getMessage());
                        Log.d("Responde_Datavalid","Exception "+e.getMessage() );
                    }


                }
            }

            @Override
            public void onFailure(Call<PF_Facil_CDVResult> call, Throwable t) {
                dialogProgressBarHider();
                dialogMensagem("Ops! Algo deu errado. \n  Tente novamente!  \n Erro: "+t.getMessage());
                Log.d("Responde_Datavalid","Falha "+t.getMessage() );
                Toast.makeText(AppActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void enviarEndPointB(String biometricaFacial, String docFrente, String docVerso){
        // JsonParser jsonParser = new JsonParser();
        // JsonObject json = jsonParser.parse(Constantes.pessoa6CDV).getAsJsonObject();
        //keyBean.setCpf("11295395045");
        keyBean.setCpf("11295395045");
        //documentoBean.setBase64(doc_frente);
        answerBean.setDocumento(new DocumentoBean("JPG",docFrente));
        answerBean.setDocumento_verso(new DocumentoBean("JPG",docVerso));
        answerBean.setBiometria_face(new DocumentoBean("JPG",biometricaFacial));
        request.setKey(keyBean);
        request.setAnswer(answerBean);
        // Log.d("Responde_Datavalid",request.getAnswer().getDocumento().getBase64());
        Call<JsonElement>  call = service.validacaoPessoaFisicaFacialCDV(request);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                dialogProgressBarHider();
                if(response.isSuccessful() && response.body() != null){
                    dialog.dismiss();
                    JsonElement jsonElement = response.body();
                    if (jsonElement.isJsonArray()) {
                        // É uma lista
                      //  JsonArray jsonArray = jsonElement.getAsJsonArray();
                        Log.d("Responde_Datavalid","1Code: "+response.code()+" - é uma lista ");
                        // Faça o parsing da lista aqui
                    } else if (jsonElement.isJsonObject()) {
                        // É um objeto
                       // JsonObject jsonObject = jsonElement.getAsJsonObject();
                        Log.d("Responde_Datavalid","1Code: "+response.code()+" - é um objeto ");
                        // Faça o parsing do objeto aqui
                    }
                    Log.d("Responde_Datavalid","1Code: "+response.code()+" - "+response.body().toString());
                }else{
                    String errorBodyString = null;
                    try {
                       // errorBodyString = response.errorBody().source().readUtf8();
                        errorBodyString = response.errorBody().toString();

                        // Converter a string JSON em um array JSON
                        JSONArray jsonArray = new JSONArray(errorBodyString);
                        String message = "";
                        String code = "";

                        // Percorrer o array e extrair os objetos individuais
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            // Verificar se o campo "id" existe no objeto JSON
                            if (jsonObject.has("code")) {
                                // Extrair os valores dos campos
                                code = jsonObject.getString("code");

                            }
                            if(jsonObject.has("message")) {
                                // Extrair os valores dos campos
                                message = jsonObject.getString("message");
                            }

                            // Fazer o que quiser com os valores obtidos
                            // Por exemplo, exibir no log
                            Log.d("Responde_Datavalid", "Item " + code + ": " + message);
                        }

                        String msg = "Code: "+code+" \n"+
                                "Message: "+message;

                        dialogMensagem(msg);

                        Log.d("Responde_Datavalid","2Code: "+response.code()+" - "+errorBodyString.toString() );
                      //  Log.d("Responde_Datavalid","2Code: "+response.code()+" - "+errorBodyString );
                   /* } catch (IOException e) {
                        dialogMensagem(e.getMessage());
                        Log.d("Responde_Datavalid","2Code: "+e.getMessage() );*/

                    } catch (JSONException e) {
                        dialogMensagem(e.getMessage());
                        Log.d("Responde_Datavalid","json "+e.getMessage() );
                        throw new RuntimeException(e);
                    }catch (Exception e){
                        dialogMensagem(e.getMessage());
                        Log.d("Responde_Datavalid","json "+e.getMessage() );
                    }


                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("Responde_Datavalid","Code: "+t.getMessage());
                Toast.makeText(AppActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void enviarEndPoint(String base64User, String baseCNHFrente, String base64CNHVErso){
       // JsonParser jsonParser = new JsonParser();
       // JsonObject json = jsonParser.parse(Constantes.pessoa6CDV).getAsJsonObject();
        //keyBean.setCpf("11295395045");
        keyBean.setCpf("02498501258");
        //documentoBean.setBase64(doc_frente);
        answerBean.setDocumento(new DocumentoBean("JPG",baseCNHFrente));
        answerBean.setDocumento_verso(new DocumentoBean("JPG",base64CNHVErso));
        answerBean.setBiometria_face(new DocumentoBean("JPG",base64User));
        request.setKey(keyBean);
        request.setAnswer(answerBean);
        // Log.d("Responde_Datavalid",request.getAnswer().getDocumento().getBase64());
        Call<PF_Facil_CDVResult> call = service.validacaoB_PessoaFisicaFacialCDV(request);
        call.enqueue(new Callback<PF_Facil_CDVResult>() {
            @Override
            public void onResponse(Call<PF_Facil_CDVResult> call, Response<PF_Facil_CDVResult> response) {
                if(response.isSuccessful()){
                    // Log.d("Responde_Datavalid","Serviço funcionando");
                    Log.d("Responde_Datavalid","1Code: "+response.code()+" - "+response.body().toString());
                }else{
                    Log.d("Responde_Datavalid","2Code: "+response.code()+" - "+response.body());
                    Toast.makeText(AppActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PF_Facil_CDVResult> call, Throwable t) {
                Log.d("Responde_Datavalid","Code: "+t.getMessage());
                Toast.makeText(AppActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void dispatchTakePictureIntent(int requestCode, ImageView targetImageView) {
        ContentValues values = new ContentValues();
        //  String fileName = "teste.jpg";
        //  values.put(MediaStore.Images.Media.TITLE, fileName);
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri); // Especifica o local para salvar a imagem

        startActivityForResult(takePictureIntent, requestCode);

        // Aqui, você pode salvar a referência ao ImageView para atualizá-lo após a captura.
        // Por exemplo, você pode armazenar o ImageView em uma variável de classe.
        this.targetImageView = targetImageView;
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

            try {
                Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                getContentResolver().delete(imageUri, null, null); /// remove a imagem salva quando tirei a foto


                saveImageToGallery(AppActivity.this,imageBitmap);

                if (imageBitmap != null) {

                    String base64Image = "";

                        // Agora você tem a imagem capturada convertida em base64
                        // Armazene-a ou faça o que quiser com ela
                        if (requestCode == REQUEST_IMAGE_SELFIE) {
                            imageBitmap = getResizedBitmap(imageBitmap, 250, 333);
                            base64Image = convertBitmapToBase64(imageBitmap);
                            // Salva na variável de selfie
                            if (base64Image != null) {
                                selfie = base64Image;
                                Toast.makeText(this, "Temos o arquivo em base64", Toast.LENGTH_SHORT).show();
                            }

                        } else if (requestCode == REQUEST_IMAGE_DOC_FRENTE) {
                            imageBitmap = getResizedBitmap(imageBitmap, 1449, 1000);
                            base64Image = convertBitmapToBase64(imageBitmap);
                            // Salva na variável de documento frente
                            if (base64Image != null) {
                                doc_frente = base64Image;
                                Toast.makeText(this, "Temos o arquivo em base64", Toast.LENGTH_SHORT).show();
                            }

                        } else if (requestCode == REQUEST_IMAGE_DOC_VERSO) {
                            imageBitmap = getResizedBitmap(imageBitmap, 1449, 1000);
                            base64Image = convertBitmapToBase64(imageBitmap);
                            // Salva na variável de documento verso
                            if (base64Image != null) {
                                doc_verso = base64Image;
                                Toast.makeText(this, "Temos o arquivo em base64", Toast.LENGTH_SHORT).show();
                            }

                        }

                    Log.d("Responde_Datavalid",base64Image);
                        //salvando log
                    LogUtils.saveLogToFile(AppActivity.this, base64Image);

                    // Atualiza o ImageView com a imagem capturada
                    if (targetImageView != null) {
                        targetImageView.setImageBitmap(imageBitmap);
                        targetImageView = null; // Limpa a referência após a atualização
                    }


                }else{
                    Toast.makeText(this, "BitMap veio null", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        String base64String = Base64.encodeToString(bytes, Base64.DEFAULT);
        return base64String.replaceAll("\\s", ""); // Remove todas as quebras de linha e espaços em branco
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

    public  void saveImageToGallery(Context context, Bitmap bitmap) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "IMG_" + timeStamp + ".JPEG";

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, imageFileName);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/JPEG");

        // Insere a imagem no MediaStore
        Uri uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        if (uri != null) {


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


           /* String imagePath = getImageFilePathFromUri(context, uri);
            Bitmap bitmaps = BitmapFactory.decodeFile(imagePath);
            String base64Image = convertBitmapToBase64(bitmaps);
            LogUtils.saveLogToFile(AppActivity.this, base64Image);*/

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
}