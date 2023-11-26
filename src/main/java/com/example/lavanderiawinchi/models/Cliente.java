package com.example.lavanderiawinchi.models;

public class Cliente {

    public MaquinaDeLavado maquinaAsignada;
    public int tiempoDeLavado;

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
}
