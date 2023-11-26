package com.example.lavanderiawinchi.models;

public class Monitor {

    private int capacidad;

    private MaquinaDeLavado[] maquinas = new MaquinaDeLavado[20];

    private Cliente c;
    private Empledo e;
    private MaquinaDeLavado m;

    public Monitor(Cliente c, Empledo e, MaquinaDeLavado m){
        this.c=c;
        this.e=e;
        this.m=m;
        this.capacidad=20;
    }

}
