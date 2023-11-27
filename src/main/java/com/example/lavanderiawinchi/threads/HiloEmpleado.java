package com.example.lavanderiawinchi.threads;

import com.example.lavanderiawinchi.models.Monitor;

import java.util.Observable;

public class HiloEmpleado extends Observable implements Runnable {
    public Monitor monitor;

    public HiloEmpleado(Monitor monitor){
        this.monitor=monitor;
    }

    @Override
    public void run() {
        if (monitor.e.maquinaEnReparacion != null){
            repararMaquina();
        }
    }

    private void repararMaquina() {
        monitor.e.repararMaquina();
    }

}
