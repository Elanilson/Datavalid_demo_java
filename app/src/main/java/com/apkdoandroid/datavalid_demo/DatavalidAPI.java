package com.apkdoandroid.datavalid_demo;

import com.apkdoandroid.datavalid_demo.model.PessoaFisica;
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
    Call<PessoaFisica> validacaoBasicaPessoaFisica(@Body JsonObject json);

    /**
     * Validação das informações básicas de uma pessoa física e a biometria das impressões digitais correspondentes
     * @param json
     * @return
     */
    @POST("validate/pf-digital")
    Call<PessoaFisica> validacaoB_PessoaFisicaDigital(@Body JsonObject json);

    @POST("validate/pf-facial")
    Call<PessoaFisica> validacaoB_PessoaFisicaFacial(@Body JsonObject json);
}
