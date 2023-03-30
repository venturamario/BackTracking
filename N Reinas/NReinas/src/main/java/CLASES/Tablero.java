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
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;


//CLASE TABLERO
public class Tablero extends JFrame {
    
    //--------------------------------ATRIBUTOS---------------------------------
    String nombreFicha = "reina.png";   //Ficha predeterminada
    Ficha ficha;            //Ficha que se coloca en el tablero
    int MAXIMOx = 700;      //Tamaño máximo del tablero en eje X
    int MAXIMOy = 700;      //Tamaño máximo del tablero en eje Y
    Casilla[][] tab;        //Objeto tablero   
    int tamaño;             //Tamaño del tablero
    int filas,columnas;     //Filas y columnas del tablero
    Color colorB = Color.WHITE;         //Color Blanco para las casillas
    Color colorN = Color.BLACK;         //Color Negro para las casillas
    
    
    
    //---------------------------------MÉTODOS----------------------------------
    //CONSTRUCTOR VACÍO
    public Tablero(int t) { 
        
        //Definir tamaño del tablero
        tamaño = t;
        filas = t;
        columnas = t;
        
        //Definir ficha predeterminada
        ficha = new Ficha(nombreFicha);
        
        //CREAR TABLERO
        tab = crearTablero(filas,columnas);
    }
    
    //CONSTRUCTOR CON NOMBRE DE FICHA
    public Tablero(String nomFicha) {
        
        //Definir tamaño del tablero
        tamaño = darTamaño();
        filas = tamaño;
        columnas = tamaño;
        
        //Definir ficha que se usará
        nombreFicha = nomFicha;
        ficha = new Ficha(nombreFicha);
        
        //CREAR TABLERO
        tab = crearTablero(filas,columnas);
    }
    
    //TAMAÑO DEL TABLERO
    private int darTamaño() {
        
        //VARIABLES
        int tam = 0;
        boolean b = false;
        
        //PREGUNTAR AL USUARIO POR EL TAMAÑO DEL TABLERO
        do {
            b = true;
            try {
                tam = Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE EL TAMAÑO DEL TABLERO GRÁFICO"));
            } catch (NumberFormatException e) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "ERROR, DATO INVÁLIDO", "ERROR",JOptionPane.WARNING_MESSAGE);
                b = false;
            }
        } while (b == false);
        
        return tam;
    }
    
    //CREACIÓN DEL TABLERO
    private Casilla[][] crearTablero(int fi, int col) {
        
        //VARIABLE QUE SE RETORNARÁ
        Casilla[][] t = new Casilla[fi][col];
        
        //ITERAR FILAS Y COLUMNAS
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                //AÑADIR CASILLA AL TABLERO
                Casilla c = new Casilla();
                c.setFicha(ficha);
                t[fila][columna] = c;
            }
        }
        
        //RETORNAR EL TABLERO CREADO
        return t;
    }
    
    //PINTAR EL TABLERO
    public void dibujarGraficamente(Graphics g) {
        
        //Variables
        filas = tamaño;
        columnas = tamaño;
            
            //ITERACIÓN DE FILAS
            for (int fila = 0; fila < filas; fila++) {
                //ITERACIÓN DE COLUMNAS
                for (int columna = 0; columna < columnas; columna++) {

                    //COGER COORDENADAS DE CADA CASILLA
                    int coordX = (fila * (MAXIMOx / filas));
                    int coordY = (columna * (MAXIMOy / columnas));
                    
                    //PARA QUE EL COLOR DE LAS CASILLAS ALTERNE ENTRE BLANCO Y NEGRO
                    int color = fila+columna;
                    if (color%2 == 0) {
                        //PAR
                        g.setColor(colorB);
                    } else {
                        //IMPAR
                        g.setColor(colorN);
                    }
                    
                    //PINTAR LA CASILLA
                    //fillRect(X1, Y1, X2, Y2) usando como parámetros las coordenadas obtenidas
                    g.fillRect(coordX, coordY, (coordX + (MAXIMOx / columnas)), (coordY + (MAXIMOy / filas)));

                    //Si la casilla esta ocupada, añadir la imagen de la ficha, sea la que sea
                    if (tab[fila][columna].getOcupada() == true) {
                        g.drawImage(ficha.getImagen(), coordX, coordY, this);
                    }
                }
            }
        }
    
    //MOSTRAR EL TABLERO POR PANTALLA
    public void paint() {
        
        add(new Dibujar());
        this.setSize(MAXIMOx+5,MAXIMOy+25);
        this.setResizable(false);
        this.setTitle("PROBLEMA DE LAS REINAS PARA TABLERO DE TAMAÑO "+tamaño+"x"+tamaño);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        repaint();
    }
    
    //GETTER DEL TAMAÑO DEL TABLERO
    public int getTamaño() {
        return tamaño;
    }
    
    //GETTER DE FILAS
    public int getFilas() {
        return filas;
    }  
    
    //GETTER DE COLUMNAS
    public int getColumnas() {
        return columnas;
    }
    
    //GETTER DEL OBJETO CASILLA EN UNA COORDENADA CONCRETA
    public Casilla getCasillaActual(int fila, int columna) {
        return tab[fila][columna];
    }
    
    //PARA MOSTRAR EL TABLERO GRÁFICAMENTE
    public class Dibujar extends JComponent {

        //Constructor vacío
        public Dibujar() {
        }

        public void paint(Graphics g) {
            
            //ITERACIÓN DE FILAS
            for (int fila = 0; fila < filas; fila++) {
                //ITERACIÓN DE COLUMNAS
                for (int columna = 0; columna < columnas; columna++) {

                    //COGER COORDENADAS DE CADA CASILLA
                    int coordX = (fila * (MAXIMOx / filas));
                    int coordY = (columna * (MAXIMOy / columnas));
                    
                    //ECOGER EL COLOR DEL QUE SE PINTARÁ LA CASILLA
                    int color = fila+columna;
                    if (color%2 == 0) {
                        //PAR
                        g.setColor(colorB);
                    } else {
                        //IMPAR
                        g.setColor(colorN);
                    }
                    
                    //PINTAR LA CASILLA
                    //fillRect(X1, Y1, X2, Y2) usando como parámetros las coordenadas obtenidas
                    g.fillRect(coordX, coordY, (coordX + (MAXIMOx / columnas)), (coordY + (MAXIMOy / filas)));

                    //Si la casilla esta ocupada, añadir la imagen de la ficha, sea la que sea
                    if (tab[fila][columna].getOcupada() == true) {
                        g.drawImage(ficha.getImagen(), coordX, coordY, this);
                    }
                }
            }
        }
    }
    
}
