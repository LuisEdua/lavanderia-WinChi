package com.example.lavanderiawinchi.models;

import java.util.Random;

public class Empledo {

    public boolean disponible;
    public MaquinaDeLavado maquinaEnReparacion;

    public Empledo(){
        this.disponible = true;
        this.maquinaEnReparacion = null;
    }

    public boolean isDisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public MaquinaDeLavado getMaquinaEnReparacion(){
        return maquinaEnReparacion;
    }

    public void setMaquinaEnReparacion(MaquinaDeLavado maquinaEnReparacion){
        this.maquinaEnReparacion = maquinaEnReparacion;
    }

    public void asignarMaquina(Cliente c, MaquinaDeLavado[] maquinas) {
        MaquinaDeLavado maquina = buscarMaquina(maquinas);
        maquina.setLibre(false);
        c.setMaquinaAsignada(maquina);
    }

    private MaquinaDeLavado buscarMaquina(MaquinaDeLavado[] maquinas){
        Random random = new Random();
        MaquinaDeLavado maquinaSeleccionada = null;
        while (maquinaSeleccionada == null){
            MaquinaDeLavado maquina = maquinas[random.nextInt(20)];
            if(maquina.isLibre()){
                maquinaSeleccionada = maquina;
            }
        }
        return maquinaSeleccionada;
    }
}
