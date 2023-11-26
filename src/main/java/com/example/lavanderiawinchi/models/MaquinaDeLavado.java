package com.example.lavanderiawinchi.models;

public class MaquinaDeLavado {

    private boolean funcional;
    private boolean ocupada;
    private int posicionX;
    private int posicionY;

    public MaquinaDeLavado(int posicionX, int posicionY){
        this.funcional = true;
        this.ocupada = true;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public boolean isFuncional() {
        return funcional;
    }

    public void setFuncional(boolean funcional) {
        this.funcional = funcional;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
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
}
