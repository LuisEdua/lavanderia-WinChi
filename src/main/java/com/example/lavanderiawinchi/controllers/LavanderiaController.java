package com.example.lavanderiawinchi.controllers;

import com.example.lavanderiawinchi.models.Cliente;
import com.example.lavanderiawinchi.models.Empledo;
import com.example.lavanderiawinchi.models.MaquinaDeLavado;
import com.example.lavanderiawinchi.models.Monitor;
import com.example.lavanderiawinchi.threads.HiloCliente;
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

    @FXML
    protected void onClickButtonController() {
        Cliente[] c = new Cliente[100];
        MaquinaDeLavado[] m = generarMaquinas();
        Empledo e = new Empledo(217, 203);
        Monitor monitor = new Monitor(c, e, m);

        circle.setFill(Color.web("#ffdf1f"));
        circle.setRadius(10);
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);
        circle.setLayoutX(e.getPosicionX());
        circle.setLayoutY(e.getPosicionY());

        panel.getChildren().add(circle);

        HiloCliente h1 = new HiloCliente(monitor);
        ClienteController clienteController = new ClienteController(panel);
        h1.addObserver(clienteController);

        Thread h = new Thread(h1);
        h.start();
    }

    private MaquinaDeLavado[] generarMaquinas() {
        MaquinaDeLavado[] ms = new MaquinaDeLavado[20];
        int py;
        int px = 125;
        for (int i=0; i<20; i++){
            if (i<5){
                py = -117;
            }
            else if(i<10){
                py = -77
                ;
            }
            else if(i<15){
                py = 72;
            }
            else {
                py = 112;
            }
            MaquinaDeLavado maquina = new MaquinaDeLavado(px, py);
            ms[i] = maquina;
            px += 75;
            if(px == 500)
                px =125;
        }
        return ms;
    }
}