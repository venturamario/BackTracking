/*
AUTORES:        Mario Ventura, Luis Miguel Vargas, Felip Toni Font
ASIGNATURA:     Algoritmia y Estructuras de Datos 1
TRABAJO:        Práctica Final: Backtracking
FECHA:          Enero de 2022
PROFESOR:       Gabriel Fiol Roig
*/

package CLASES;

import java.awt.Color;
import java.awt.Graphics;

//CLASE CASILLA PARA EL TABLERO DE AJEDREZ
public class Casilla {
    
    //---------------------ATRIBUTOS DE LA CLASE CASILLA------------------------
    boolean ocupada;        //True si la casilla está ocupada
    int fila;               //Fila en la que se encuentra la casilla
    int columna;            //Columna en la que se encuentra la casilla
    Color color;            //Color de la ficha
    static Ficha ficha;     //Objeto ficha
    
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
    
    //Método para pintar una ficha encima
    public void pintarFicha(Graphics g, int x, int y) {
        g.drawImage(ficha.getImagen(), x, y, null);
    }
}

