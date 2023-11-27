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


    private Random random = new Random();

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
                    rutina(indice);
                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void rutina(int indice) {
        entrada(indice);
        lavar(indice);
        irse(indice);
        salir(indice);
    }

    private void salir(int i) {
        Cliente cliente = m.clientes[i];
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        m.salidaCliente(i);
        cliente.setIrse(true);
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(cliente);
        });
        m.clientes[i]=null;
        System.out.println("Se fue");
    }

    private void irse(int i) {
        System.out.println("Saliendo");
        Cliente cliente = m.clientes[i];
        cliente.setPosicionX(195);
        cliente.setPosicionY(215);
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(cliente);
        });
    }

    private void lavar(int i) {
        Cliente c = m.clientes[i];
        System.out.println("Lavando");
        try {
            Thread.sleep(c.getTiempoDeLavado());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(100) == 1){
            c.maquinaAsignada.setFuncional(false);
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
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(c);
        });
        System.out.println("Entro");
    }

    public void generarClientes(int i){
        Cliente c = new Cliente(random.nextInt(5000) + 5000,195, 203 );
        m.clientes[i]=c;
    }
}
