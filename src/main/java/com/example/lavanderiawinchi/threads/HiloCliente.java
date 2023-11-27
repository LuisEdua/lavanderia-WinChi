package com.example.lavanderiawinchi.threads;

import com.example.lavanderiawinchi.controllers.EmpleadoController;
import com.example.lavanderiawinchi.models.Cliente;
import com.example.lavanderiawinchi.models.Monitor;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HiloCliente extends Observable implements Runnable{
    public Monitor m;


    private Random random = new Random();
    private HiloEmpleado hiloEmpleado;

    ExecutorService executor = Executors.newFixedThreadPool(100);

    public HiloCliente(Monitor m, HiloEmpleado h1){
        this.m = m;
        this.hiloEmpleado = h1;
    }


    @Override
    public void run() {
        for (int i = 0; i<100; i++){
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
        salir(indice);
        irse(indice);
    }

    private void irse(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Cliente cliente = m.clientes[i];
        m.salidaCliente(i);
        cliente.setIrse(true);
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(cliente);
        });
        m.clientes[i]=null;
        Thread h = new Thread(hiloEmpleado);
        h.start();
    }

    private void salir(int i) {
        Cliente cliente = m.clientes[i];
        cliente.setPosicionX(-10);
        cliente.setPosicionY(-20);
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(cliente);
        });
    }

    private void lavar(int i) {
        Cliente c = m.clientes[i];
        try {
            Thread.sleep(c.getTiempoDeLavado());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int probabilidad = random.nextInt(4);
        if (probabilidad == 1){
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
    }

    public void generarClientes(int i){
        Cliente c = new Cliente(random.nextInt(5000) + 5000,195, 203 );
        m.clientes[i]=c;
    }
}
