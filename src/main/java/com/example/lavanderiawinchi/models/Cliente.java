package com.example.lavanderiawinchi.models;

public class Cliente {

    public MaquinaDeLavado maquinaAsignada;
    public int tiempoDeLavado;
    public int posicionX;
    public int posicionY;

    public Cliente(int tL){
        this.maquinaAsignada = null;
        this.tiempoDeLavado = tL;
    }

    public MaquinaDeLavado getMaquinaAsignada(){
        return maquinaAsignada;
    }

    public void setMaquinaAsignada(MaquinaDeLavado maquina) {
        this.maquinaAsignada = maquina;
    }

    public int getTiempoDeLavado(){
        return tiempoDeLavado;
    }

    public void setPosicionX(int p){
        this.posicionX = p;
    }

    public int getPosicionX(){
        return posicionX;
    }

    public void setPosicionY(int p){
        this.posicionY = p;
    }

    public int getPosicionY(){
        return posicionY;
    }
}
