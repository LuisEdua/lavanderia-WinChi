package com.example.lavanderiawinchi.models;

public class Monitor {

    private int capacidad;

    public MaquinaDeLavado[] maquinas;
    public Cliente[] clientes;

    public Empledo e;

    public Monitor(Cliente[] c, Empledo e, MaquinaDeLavado[] m){
        this.clientes=c;
        this.e=e;
        this.maquinas=m;
        this.capacidad=20;
    }

    public synchronized void entradaCliente(int i){
        while(capacidad == 0 && !e.isDisponible()) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        e.setDisponible(false);
        e.asignarMaquina(clientes[i], maquinas);
    }

}
