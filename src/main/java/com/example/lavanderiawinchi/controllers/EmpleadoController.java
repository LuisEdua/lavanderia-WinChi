package com.example.lavanderiawinchi.controllers;

import com.example.lavanderiawinchi.models.Empleado;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

public class EmpleadoController implements Observer {
    private AnchorPane panel;

    public EmpleadoController(AnchorPane panel){
        this.panel = panel;
    }

    @Override
    public void update(Observable observable, Object o) {
        Empleado e = (Empleado) o;
        ((Pane)e.getCircle().getParent()).getChildren().remove(e.getCircle());
        panel.getChildren().add(e.getCircle());
    }
}
