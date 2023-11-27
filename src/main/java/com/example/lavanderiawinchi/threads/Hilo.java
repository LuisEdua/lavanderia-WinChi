package com.example.lavanderiawinchi.threads;

import com.example.lavanderiawinchi.models.Monitor;

public class Hilo implements Runnable{

    public Monitor monitor;

    public Hilo(Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i<100; i++){
            monitor.entradaCliente(i);
        }
    }
}
