package com.example.lavanderiawinchi.models;

public class Empledo {

    public boolean disponible;
    public int maquinaEnReparacion;

    public Empledo(){
        this.disponible = true;
        this.maquinaEnReparacion = -1;
    }

    public boolean isDisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public int getMaquinaEnReparacion(){
        return maquinaEnReparacion;
    }

    public void setMaquinaEnReparacion(int maquinaEnReparacion){
        this.maquinaEnReparacion = maquinaEnReparacion;
    }

}
