package com.pj.sanjuan.elecciones.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.pj.sanjuan.elecciones.R;
import com.pj.sanjuan.elecciones.io.JuntaElectoralAPI;
import com.pj.sanjuan.elecciones.model.DepartamentoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryActivity extends AppCompatActivity {

    private final String baseURL = "http://200.0.236.210/AresAPI/";
    private RecyclerView rvDepartamento;
    private rvAdapterDepartamento adaptadorDepartamento;
    List<DepartamentoModel> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        setTitle("Galeria");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Retrofit retrofit  = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JuntaElectoralAPI service = retrofit.create(JuntaElectoralAPI.class);

        final Call<List<DepartamentoModel>> lista = service.getDepartamento();
        lista.enqueue(new Callback<List<DepartamentoModel>>() {
            @Override
            public void onResponse(Call<List<DepartamentoModel>> call, Response<List<DepartamentoModel>> response) {
                if(response.isSuccessful()) {
                    listaPersonas = response.body();
                    rvDepartamento=(RecyclerView)findViewById(R.id.rvDepartamentos);

                    // use this setting to improve performance if you know that changes
                    // in content do not change the layout size of the RecyclerView
                    rvDepartamento.setHasFixedSize(true);

                    // use a linear layout manager
                    rvDepartamento.setLayoutManager(new LinearLayoutManager(GalleryActivity.this));

                    // specify an adapter with the list to show
                    adaptadorDepartamento=new rvAdapterDepartamento(listaPersonas);
                    rvDepartamento.setAdapter(adaptadorDepartamento);
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<List<DepartamentoModel>> call, Throwable t) {

            }
        });
    }

}
