package com.example.lavanderiawinchi.threads;

import com.example.lavanderiawinchi.models.Empleado;
import com.example.lavanderiawinchi.models.Monitor;
import javafx.application.Platform;

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
        Empleado e = monitor.e;
        e.setPosicionX(e.maquinaEnReparacion.getPosicionX() + 195);
        e.setPosicionY(e.maquinaEnReparacion.getPosicionY() + 202);
        Platform.runLater(() -> {
            this.setChanged();
            this.notifyObservers(e);
        });
        monitor.repararMaquina();
        e.setPosicionY(203);
        e.setPosicionX(217);
    }

}
