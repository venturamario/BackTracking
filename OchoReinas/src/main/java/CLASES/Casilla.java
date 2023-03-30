package CLASES;

//CLASE CASILLA PARA EL TABLERO DE AJEDREZ

import java.awt.Color;

public class Casilla {
    
    //---------------------ATRIBUTOS DE LA CLASE CASILLA------------------------
    boolean ocupada; //True si la casilla está ocupada
    int fila;
    int columna; 
    Color color;
    Ficha ficha;
    
    //-----------------------MÉTODOS DE LA CLASE CASILLA------------------------
    
    //CONSTRUCTOR VACÍO
    public Casilla() {
        ocupada = false;
        ficha = null;
    }
    
    //GETTERS
    public boolean getOcupada() {
        return ocupada;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Color getColor() {
        return color;
    }

    public Ficha getFicha() {
        return ficha;
    }
    
    //SETTERS
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
    
}
