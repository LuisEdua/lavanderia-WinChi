package com.example.lavanderiawinchi.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cliente {

    public MaquinaDeLavado maquinaAsignada;
    public int tiempoDeLavado;
    public int posicionX;
    public int posicionY;
    public Circle circle;
    private boolean irse;

    public Cliente(int tL, int px, int py){
        this.maquinaAsignada = null;
        this.tiempoDeLavado = tL;
        this.posicionX=px;
        this.posicionY=py;
        this.circle = new Circle(px, py, 10);
        this.circle.setFill(Color.RED);
        this.irse = false;
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
        this.circle.setLayoutX(p);
    }

    public void setPosicionY(int p){
        this.posicionY = p;
        this.circle.setLayoutY(p);
    }

    public void setCircle(Circle circle){
        this.circle=circle;
        this.circle=circle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setIrse(boolean irse){
        this.irse=irse;
    }

    public boolean getIrse(){
        return irse;
    }
}
