package com.example.lavanderiawinchi.controllers;

import com.example.lavanderiawinchi.models.Cliente;
import com.example.lavanderiawinchi.models.Empledo;
import com.example.lavanderiawinchi.models.MaquinaDeLavado;
import com.example.lavanderiawinchi.models.Monitor;
import com.example.lavanderiawinchi.threads.Hilo;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class LavanderiaController {

    @FXML
    private AnchorPane panel;
    @FXML
    private Circle circle = new Circle();

    private EmpleadoController empleadoController;

    @FXML
    protected void onClickButtonController() {
        Cliente[] c = new Cliente[100];
        MaquinaDeLavado[] m = generarMaquinas();
        Empledo e = new Empledo(217, 203);
        Monitor monitor = new Monitor(c, e, m);
        Hilo h2 = new Hilo(monitor);

        circle.setFill(Color.web("#ffdf1f"));
        circle.setRadius(10);
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);
        circle.setLayoutX(e.getPosicionX());
        circle.setLayoutX(e.getPosicionY());

        panel.getChildren().add(circle);
    }



    private MaquinaDeLavado[] generarMaquinas() {
        MaquinaDeLavado[] ms = new MaquinaDeLavado[20];
        int py, px = 317;
        for (int i=0; i<20; i++){
            if (i<5){
                py = 95;
            }
            else if(i<10){
                py = 127;
            }
            else if(i<15){
                py = 284;
            }
            else {
                py = 315;
            }
            MaquinaDeLavado maquina = new MaquinaDeLavado(px, py);
            ms[i] = maquina;
            px += 75;
            if(px == 692)
                px =317;
        }
        return ms;
    }
}