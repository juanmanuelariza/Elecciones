package com.pj.sanjuan.elecciones.model;
/**
 * Created by JuanManuel on 14/6/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartamentoModel {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Zona")
    @Expose
    private Integer zona;

    public Integer getID() {
        return getiD();
    }

    public void setID(Integer iD) {
        this.setiD(iD);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }
}