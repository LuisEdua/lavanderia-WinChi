package com.example.lavanderiawinchi.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cliente {

    public MaquinaDeLavado maquinaAsignada;
    public int tiempoDeLavado;
    public int posicionX;
    public int posicionY;
    public Circle circle;

    public Cliente(int tL, int px, int py){
        this.maquinaAsignada = null;
        this.tiempoDeLavado = tL;
        this.posicionX=px;
        this.posicionY=py;
        this.circle = new Circle(px, py, 10);
        this.circle.setFill(Color.RED);
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

    public int getPosicionX(){
        return posicionX;
    }

    public void setPosicionY(int p){
        this.posicionY = p;
        this.circle.setLayoutY(p);
    }

    public int getPosicionY(){
        return posicionY;
    }

    public Circle getCircle() {
        return circle;
    }
}
