package com.apkdoandroid.datavalid_demo;

import com.apkdoandroid.datavalid_demo.model.Pessoa;
import com.apkdoandroid.datavalid_demo.model.StatusResposta;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DatavalidAPI {

    /**
     * Permite obter informação da disponibilidade do serviço, onde é obtido através do código HTTP de retorno
     * @return
     */
    @GET("status")
    Call<StatusResposta> verificarServico();

    /**
     * Validação das informações básicas de uma pessoa física
     * @return
     */
    @POST("validate/pf-basica")
    Call<Pessoa> validacaoBasicaCPF(@Body JsonObject json);
}
