package com.example.lavanderiawinchi.threads;

import com.example.lavanderiawinchi.models.Cliente;
import com.example.lavanderiawinchi.models.Monitor;
import javafx.application.Platform;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HiloCliente extends Observable implements Runnable{
    public Monitor m;

    ExecutorService executor = Executors.newFixedThreadPool(30);

    public HiloCliente(Monitor m){
        this.m = m;
    }


    @Override
    public void run() {
        for (int i = 0; i<30; i++){
            final int indice = i;
            generarClientes(indice);
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    entrada(indice);
                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void entrada(int i) {
        Cliente c = m.clientes[i];
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(c);
        });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        m.entradaCliente(i);
        this.setChanged();
        this.notifyObservers(c);
    }

    public void generarClientes(int i){
        Random random = new Random();
        Cliente c = new Cliente(random.nextInt(5000) + 5000,195, 203 );
        m.clientes[i]=c;
    }
}
