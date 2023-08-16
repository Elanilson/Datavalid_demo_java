package com.apkdoandroid.datavalid_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apkdoandroid.datavalid_demo.model.PessoaFisica;
import com.apkdoandroid.datavalid_demo.model.StatusResposta;
import com.apkdoandroid.datavalid_demo.util.Constantes;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private DatavalidAPI service;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PRECISO TRATAR QUANDO DER ERRO
        //PRECISO TRATAR QUANDO DER ERRO
        //PRECISO TRATAR QUANDO DER ERRO
        //PRECISO TRATAR QUANDO DER ERRO
        //PRECISO TRATAR QUANDO DER ERRO
        //PRECISO TRATAR QUANDO DER ERRO

        service = RetrofitClient.classService(DatavalidAPI.class);
        button = findViewById(R.id.buttonStatus);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<StatusResposta> call = service.verificarServico();
                call.enqueue(new Callback<StatusResposta>() {
                    @Override
                    public void onResponse(Call<StatusResposta> call, Response<StatusResposta> response) {
                        if(response.isSuccessful()){
                            Log.d("Responde_Datavalid","Serviço funcionando");
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.body());
                        }else{
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.errorBody());
                            Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<StatusResposta> call, Throwable t) {
                        Log.d("Responde_Datavalid","Code: "+t.getMessage());
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        findViewById(R.id.validacaoBasica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonParser jsonParser = new JsonParser();
                JsonObject json = jsonParser.parse(Constantes.pessoa1).getAsJsonObject();
                Call<PessoaFisica> call = service.validacaoBasicaPessoaFisica(json);
                call.enqueue(new Callback<PessoaFisica>() {
                    @Override
                    public void onResponse(Call<PessoaFisica> call, Response<PessoaFisica> response) {
                        if(response.isSuccessful()){
                           // Log.d("Responde_Datavalid","Serviço funcionando");
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.body().toString());
                        }else{
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.errorBody());
                            Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PessoaFisica> call, Throwable t) {
                        Log.d("Responde_Datavalid","Code: "+t.getMessage());
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        findViewById(R.id.validacaoDigital).setOnClickListener(new View.OnClickListener() {

            /**
             * ELE TÁ RETORNANDO COD: 400 PORQUE NÃO TA SENDO A IMAGEM DE BIOMETRIA EM BASE64
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                JsonParser jsonParser = new JsonParser();
                JsonObject json = jsonParser.parse(Constantes.pessoa2Digital).getAsJsonObject();
                Call<PessoaFisica> call = service.validacaoB_PessoaFisicaDigital(json);
                call.enqueue(new Callback<PessoaFisica>() {
                    @Override
                    public void onResponse(Call<PessoaFisica> call, Response<PessoaFisica> response) {
                        if(response.isSuccessful()){
                            // Log.d("Responde_Datavalid","Serviço funcionando");
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.body().toString());
                        }else{
                            Log.d("Responde_Datavalid","Code: "+response.code()+" - "+response.errorBody());
                            Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PessoaFisica> call, Throwable t) {
                        Log.d("Responde_Datavalid","Code: "+t.getMessage());
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}