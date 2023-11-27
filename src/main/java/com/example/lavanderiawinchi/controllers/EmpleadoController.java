package com.example.lavanderiawinchi.controllers;

import com.example.lavanderiawinchi.models.Empledo;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

import java.util.Observable;
import java.util.Observer;

public class EmpleadoController implements Observer {

    @FXML
    private Circle circle = new Circle();
    
    
    @Override
    public void update(Observable observable, Object o) {
        Empledo e = (Empledo) o;

    }
}
