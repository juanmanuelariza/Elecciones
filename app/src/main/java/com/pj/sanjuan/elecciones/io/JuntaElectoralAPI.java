package com.pj.sanjuan.elecciones.io;

import com.pj.sanjuan.elecciones.model.DepartamentoModel;
import com.pj.sanjuan.elecciones.model.DepartamentoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JuanManuel on 14/6/2018.
 */

public interface JuntaElectoralAPI {
    @GET("api/Departamento")
    Call<List<DepartamentoModel>> getDepartamento();

}
