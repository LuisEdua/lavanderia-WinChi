package com.example.lavanderiawinchi.models;

public class Monitor {

    private int capacidad;

    public MaquinaDeLavado[] maquinas;
    public Cliente[] clientes;

    public Empleado e;

    public Monitor(Cliente[] c, Empleado e, MaquinaDeLavado[] m){
        this.clientes=c;
        this.e=e;
        this.maquinas=m;
        this.capacidad=20;
    }

    public synchronized void entradaCliente(int i){
        while(capacidad == 0 || !e.isDisponible() || e.getMaquinaEnReparacion() != null) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        e.setDisponible(false);
        e.asignarMaquina(clientes[i], maquinas);
        e.setDisponible(true);
        this.notifyAll();
    }

    public synchronized void salidaCliente(int i){
        while (!e.isDisponible() || e.getMaquinaEnReparacion() != null){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        e.setDisponible(false);
        e.verificar(clientes[i]);
        e.setDisponible(true);
        this.notifyAll();
    }

}
