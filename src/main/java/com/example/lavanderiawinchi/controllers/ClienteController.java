package com.example.lavanderiawinchi.controllers;

import com.example.lavanderiawinchi.models.Cliente;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class ClienteController implements Observer {
    private AnchorPane panel;
    public ClienteController(AnchorPane panel){
        this.panel = panel;
    }
    @Override
    public void update(Observable observable, Object o) {
        Cliente c = (Cliente) o;
        if(c.getCircle().getParent() != null){
            ((Pane)c.getCircle().getParent()).getChildren().remove(c.getCircle());
        }
        panel.getChildren().add(c.getCircle());
    }
}
