package com.apkdoandroid.datavalid_demo;

import com.apkdoandroid.datavalid_demo.util.Constantes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit INSTANCE;
    private RetrofitClient(){}
    private static Retrofit getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(Constantes.base_url)
                    .client(clientHttp().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }

    public static <T> T classService(Class<T> classService){
        return getInstance().create(classService);
    }

    private static OkHttpClient.Builder clientHttp() {

        /*
            Os valores padrão para os tempos limite do OkHttpClient são os seguintes:

            connectTimeout: 10 segundos
            readTimeout: 10 segundos
            writeTimeout: 10 segundos
         */
            OkHttpClient.Builder client = new OkHttpClient.Builder();

            // Define os tempos limite
            client.connectTimeout(22, TimeUnit.SECONDS); // Tempo limite para estabelecer a conexão
            client.readTimeout(22, TimeUnit.SECONDS);    // Tempo limite para leitura da resposta
            client.writeTimeout(22, TimeUnit.SECONDS);   // Tempo limite para escrever a requisição

            client.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e")
                            .build();
                    return chain.proceed(request);
                }

            });
            return client;
    }
}
