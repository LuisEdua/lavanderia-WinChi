package com.example.lavanderiawinchi.models;

import java.util.Random;

public class Empleado {

    public boolean disponible;
    public MaquinaDeLavado maquinaEnReparacion;
    private int posicionX;
    private int posicionY;

    Random random = new Random();

    public Empleado(int px, int py){
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
        c.setPosicionX(maquina.getPosicionX());
        c.setPosicionY(maquina.getPosicionY());
    }

    private MaquinaDeLavado buscarMaquina(MaquinaDeLavado[] maquinas){
        MaquinaDeLavado maquinaSeleccionada = null;
        while (maquinaSeleccionada == null){
            MaquinaDeLavado maquina = maquinas[random.nextInt(20)];
            if(maquina.isLibre() && maquina.isFuncional()){
                maquinaSeleccionada = maquina;
            }
        }
        return maquinaSeleccionada;
    }

    public void verificar(Cliente cliente) {
        MaquinaDeLavado maquina = cliente.maquinaAsignada;
        if (!maquina.isFuncional()){
            this.maquinaEnReparacion = maquina;
        }
        cliente.maquinaAsignada = null;
        maquina.setLibre(true);
    }

    public void repararMaquina() {
        try {
            Thread.sleep(random.nextInt(1000)+2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.maquinaEnReparacion.setFuncional(true);
        this.maquinaEnReparacion=null;
    }
}
