package com.example.lavanderiawinchi.models;

import java.util.Random;

public class Empledo {

    public boolean disponible;
    public MaquinaDeLavado maquinaEnReparacion;
    private int posicionX;
    private int posicionY;

    public Empledo(int px, int py){
        this.disponible = true;
        this.maquinaEnReparacion = null;
        this.posicionX = px;
        this.posicionY = py;
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

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
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
